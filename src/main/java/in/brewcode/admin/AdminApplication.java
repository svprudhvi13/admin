package in.brewcode.admin;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class/*, AuthenticationManagerConfiguration.class, SpringBootWebSecurityConfiguration.class*/})
//@ComponentScan(basePackages={"in.brewcode.admin"})
@EnableOAuth2Client
@EnableConfigurationProperties
public class AdminApplication {

	
	private static Logger logger = Logger.getLogger(AdminApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	
		
	}
	@Bean(name="restTemplate")
	public RestTemplate getRestTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		logger.info("intialized rest template");
		return restTemplate;
		
	}
	

	@Bean
	@ConfigurationProperties(prefix="security.oauth2.client")
	public OAuth2ProtectedResourceDetails clientCredentialsResourceDetails(){
		return new ClientCredentialsResourceDetails(); 
	}
	
@Bean(name="ouath2RestTemplate")
public OAuth2RestTemplate getOAuth2RestTemplate(OAuth2ProtectedResourceDetails ccrd){
	AccessTokenRequest accessTokenRequest = new DefaultAccessTokenRequest();
	OAuth2ClientContext context = new DefaultOAuth2ClientContext(accessTokenRequest);
	logger.debug("Checking loading of security.oauth2.client properties------");
	logger.info("Initializing oauth2RestTemplate, client Id:" +ccrd.getClientId());
	logger.debug("Finished Checking loading of security.oauth2.client properties");
	
	return new OAuth2RestTemplate(ccrd, context);
}

@Bean 
public AccessTokenRequest getAccessTokenRequest(){
	return new DefaultAccessTokenRequest();
	
}
@Bean
@ConfigurationProperties(prefix="security.oauth2.client")
public ResourceOwnerPasswordResourceDetails getResourceOwnerDetails(){
	ResourceOwnerPasswordResourceDetails roprd= new ResourceOwnerPasswordResourceDetails();
	logger.info("Initializing ResourceOwnerPasswordDetails " );
	
	return roprd;
}

}
