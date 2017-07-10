package in.brewcode.admin.service;

import in.brewcode.admin.dto.AuthorDto;
import in.brewcode.admin.dto.AuthorRegistrationDto;

import java.net.URISyntaxException;

import javax.security.auth.login.LoginException;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

public interface ILoginService {

	/**
	 * Overloaded login method
	 * @throws URISyntaxException 
	 */
	public  AuthorRegistrationDto login(String username, String password) throws LoginException, URISyntaxException;
	
	public void logout();

	OAuth2AccessToken getoAuth2AccessToken();
}
