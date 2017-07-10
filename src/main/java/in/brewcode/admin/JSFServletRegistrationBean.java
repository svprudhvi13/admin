package in.brewcode.admin;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletRegistrationBean;

import com.sun.faces.config.FacesInitializer;

/**
 * 
 * @author ai
 *
 */
public class JSFServletRegistrationBean extends ServletRegistrationBean {

	private static final String[] URL_MAPPINGS = { "/faces/**", "*.xhtml" };

	
	
	public JSFServletRegistrationBean() {
	super();
	}





	public JSFServletRegistrationBean(Servlet servlet, String... urlMappings) {
		super(servlet, urlMappings);
	}



	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		FacesInitializer facesInitializer = new FacesInitializer();

		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(JSFConfig.class);
		
		facesInitializer.onStartup(classes, servletContext);
		
		this.addUrlMappings(URL_MAPPINGS);

	}

}
