package in.brewcode.admin.model;

import in.brewcode.admin.dto.AuthorDto;
import in.brewcode.admin.dto.AuthorLoginDto;
import in.brewcode.admin.dto.AuthorRegistrationDto;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
@Component
public class RegistrationBean {
	
	
	private static final Logger LOG = Logger
			.getLogger(RegistrationBean.class);
	
	private AuthorRegistrationDto authorRegistration=getAuthorRegistration();
	

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

	return "blog";
	
	}
	
	public String update(){
		LOG.info("updating");
		return "index";
	}

}
