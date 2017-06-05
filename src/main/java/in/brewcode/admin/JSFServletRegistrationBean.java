package in.brewcode.admin;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.stereotype.Component;

import com.sun.faces.config.FacesInitializer;
/**
 * 
 * @author ai
 *
 */
@Component
public class JSFServletRegistrationBean extends ServletRegistrationBean {

	private static final String[] URL_MAPPINGS={"/faces/**", "*.xhtml"};
	
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
FacesInitializer facesInitializer = new FacesInitializer();

Set<Class<?>> classes = new HashSet<Class<?>>();
classes.add(AdminApplication.class);

facesInitializer.onStartup(classes, servletContext);
	this.addUrlMappings(URL_MAPPINGS);
	
	}
	
	
}
