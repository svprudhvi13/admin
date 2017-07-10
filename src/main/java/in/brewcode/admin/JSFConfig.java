package in.brewcode.admin;

import javax.faces.webapp.FacesServlet;

import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value={"dev", "prod"})
public class JSFConfig {

	private static Logger logger = Logger.getLogger(JSFConfig.class);


@Bean 
public FacesServlet getFacesServlet(){
	return new FacesServlet();
}
	@Bean
public ServletRegistrationBean servletRegistrationBean(FacesServlet facesServlet){
logger.info("Initializing ServletRegistrationBean");
final String[] URL_MAPPINGS = { "/faces/**", "*.xhtml" };
	return new JSFServletRegistrationBean(facesServlet, URL_MAPPINGS);
}

}
