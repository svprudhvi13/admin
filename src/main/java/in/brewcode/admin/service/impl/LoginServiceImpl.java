package in.brewcode.admin.service.impl;

import in.brewcode.admin.dto.AuthorDto;
import in.brewcode.admin.dto.AuthorRegistrationDto;
import in.brewcode.admin.service.ILoginService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class LoginServiceImpl implements ILoginService {

	private static final Logger LOG = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private OAuth2RestTemplate oAuth2RestTemplate;

	@Autowired
	private ResourceOwnerPasswordResourceDetails resourceOwnerDetails;

	private AccessTokenProvider accessTokenProvider;

	private OAuth2AccessToken oAuth2AccessToken;

	@Override
	public AuthorRegistrationDto login(final String username, final String password)
			throws RestClientException, URISyntaxException {
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		map.put("grant_type", "password");
		LOG.info("Client Token"
				+ oAuth2RestTemplate.getAccessToken().toString());
		DefaultAccessTokenRequest accessTokenRequest = new DefaultAccessTokenRequest();
		accessTokenRequest
				.setCurrentUri("http://localhost:8080/brewcode/oauth/token");
		accessTokenRequest.setAll(map);
		accessTokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
		oAuth2AccessToken = accessTokenProvider.obtainAccessToken(
				resourceOwnerDetails, accessTokenRequest);
		
		
		oAuth2RestTemplate.getOAuth2ClientContext().setAccessToken(
				oAuth2AccessToken);
		LOG.info("UserToken: " + oAuth2RestTemplate.getAccessToken().toString());
		ResponseEntity<AuthorRegistrationDto> author = (ResponseEntity<AuthorRegistrationDto>) oAuth2RestTemplate
				.getForEntity(new URI("http://localhost:8080/brewcode/user/"
						+ username), AuthorRegistrationDto.class);
		AuthorRegistrationDto authorDto = author.getBody();
		return authorDto;
	}

	@Override
	public void logout() {
		//logout logic
	}

	@Override
	public OAuth2AccessToken getoAuth2AccessToken() {
		return oAuth2AccessToken;
	}

	public void setoAuth2AccessToken(OAuth2AccessToken oAuth2AccessToken) {
		this.oAuth2AccessToken = oAuth2AccessToken;
	}

	

}
