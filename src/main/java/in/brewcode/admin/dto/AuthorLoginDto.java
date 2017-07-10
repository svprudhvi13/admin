package in.brewcode.admin.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.NotNull;

@ManagedBean(name="authorLogin", eager=true)
public class AuthorLoginDto {
	@Override
	public String toString() {
		return "AuthorLoginDto [authorDto=" + authorDto
				+ ", authorMobileNumber=" + authorMobileNumber + "]";
	}

	/**
	 * This field encapsulates username and email
	 */
	@NotNull
	@ManagedProperty("#{author}")
	private AuthorDto authorDto;
	@NotNull
	@ManagedProperty("#{password}")
	private String adminPassword;

	@ManagedProperty("#{mobileNumber}")
	private String authorMobileNumber;
	@NotNull
	//@JsonIgnore
	//@org.codehaus.jackson.annotate.JsonIgnore
	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public AuthorDto getAuthorDto() {
		return authorDto;
	}

	public void setAuthorDto(AuthorDto authorDto) {
		this.authorDto = authorDto;
	}
	@NotNull
	//@JsonIgnore
	//@org.codehaus.jackson.annotate.JsonIgnore
	public String getAuthorMobileNumber() {
		return authorMobileNumber;
	}

	public void setAuthorMobileNumber(String authorMobileNumber) {
		this.authorMobileNumber = authorMobileNumber;
	}

	// Shalln't retreive Password
	/*
	 * public String getAdminPassword() { return adminPassword; }
	 */

}
