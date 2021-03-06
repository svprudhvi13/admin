package in.brewcode.admin.dto;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@ManagedBean(name="authorRegistration", eager=true)
public class AuthorRegistrationDto {
	@Override
	public String toString() {
		return "AuthorRegistrationDto [adminFirstName=" + adminFirstName
				+ ", adminLastName=" + adminLastName + ", adminDateOfBirth="
				+ adminDateOfBirth + ", adminCreatedDate=" + adminCreatedDate
				+ ", address=" + address + ", authorLoginDto=" + authorLoginDto
				+ "]";
	}

	@NotNull
	private String adminFirstName;
	
	@NotNull
		private String adminLastName;
	//@NotNull
	@org.codehaus.jackson.annotate.JsonIgnore
	private Date adminDateOfBirth;
	
	@JsonIgnore
	@org.codehaus.jackson.annotate.JsonIgnore
	private Date adminCreatedDate;
	
	@NotNull
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@ManagedProperty("#{authorLogin}")
	private AuthorLoginDto authorLoginDto;
	
	@NotNull
	private String confirmPassword;

	public Date getAdminDateOfBirth() {
		return adminDateOfBirth;
	}

	public void setAdminDateOfBirth(Date adminDateOfBirth) {
		this.adminDateOfBirth = adminDateOfBirth;
	}



	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	/*
	 * * All Details of this class, along with adminName ie., unique user id of
	 * super class is show by this method
	 */
	

	public Date getAdminCreatedDate() {
		return adminCreatedDate;
	}

	public void setAdminCreatedDate(Date adminCreatedDate) {
		this.adminCreatedDate = adminCreatedDate;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public AuthorLoginDto getAuthorLoginDto() {
		return authorLoginDto;
	}

	public void setAuthorLoginDto(AuthorLoginDto authorLoginDto) {
		this.authorLoginDto = authorLoginDto;
	}

}
