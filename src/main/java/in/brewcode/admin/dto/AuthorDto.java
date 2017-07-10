package in.brewcode.admin.dto;

import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.NotNull;

public class AuthorDto {

	@Override
	public String toString() {
		return "AuthorDto [authorUserName=" + authorUserName + ", authorEmail="
				+ authorEmail + "]";
	}

	@NotNull
	@ManagedProperty("#{username}")
	private String authorUserName;

	@NotNull
	@ManagedProperty("#{email}")
	private String authorEmail;

	@NotNull
	//@JsonIgnore
	//@org.codehaus.jackson.annotate.JsonIgnore
	public String getAuthorUserName() {
		return authorUserName;
	}

	public void setAuthorUserName(String authorUserName) {
		this.authorUserName = authorUserName;
	}

	@NotNull
	//@JsonIgnore
	//@org.codehaus.jackson.annotate.JsonIgnore
	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

}
