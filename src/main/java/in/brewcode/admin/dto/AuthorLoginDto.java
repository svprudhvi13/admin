package in.brewcode.admin.dto;

import javax.validation.constraints.NotNull;

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
	private AuthorDto authorDto;
	@NotNull
	private String adminPassword;
	
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
