package in.brewcode.admin.model;

import in.brewcode.admin.dto.AuthorDto;
import in.brewcode.admin.dto.AuthorLoginDto;
import in.brewcode.admin.dto.AuthorRegistrationDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@ManagedBean(eager=true, name="registrationBean")
@RequestScoped
@Component
public class RegistrationBean {
	
	
	private static final Logger LOG = Logger
			.getLogger(RegistrationBean.class);
	@ManagedProperty("registrationBean")
	private AuthorRegistrationDto authorRegistration;
	
	@Autowired
	@ManagedProperty("#{headerNavigationBean}")
	public HeaderNavigationBean headerNavigationBean;
	public HeaderNavigationBean getHeaderNavigationBean() {
		return headerNavigationBean;
	}
	public void setHeaderNavigationBean(HeaderNavigationBean headerNavigationBean) {
		this.headerNavigationBean = headerNavigationBean;
	}

	public RegistrationBean(){
	}

	public AuthorRegistrationDto getAuthorRegistration() {
		if(this.authorRegistration==null){
			this.authorRegistration=new AuthorRegistrationDto();
			this.authorRegistration.setAuthorLoginDto(new AuthorLoginDto());
			this.authorRegistration.getAuthorLoginDto().setAuthorDto(new AuthorDto());

		}
		return authorRegistration;
	}

	public void setAuthorRegistration(AuthorRegistrationDto authorRegistration) {

		LOG.info("set registering");
		System.out.println("set registering");
		this.authorRegistration = authorRegistration;
	}

	public String register(){
		LOG.info("registering"+authorRegistration.toString());
		headerNavigationBean.setPage("profile");

	return "blog";
	
	}
	
	public String update(){
		LOG.info("updating");
		return "index";
	}

}
