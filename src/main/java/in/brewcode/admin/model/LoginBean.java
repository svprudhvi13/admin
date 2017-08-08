package in.brewcode.admin.model;

import in.brewcode.admin.dto.AuthorRegistrationDto;
import in.brewcode.admin.service.ILoginService;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

//Using CDI annotation instead of JSF annotation for maintainence in future
//@ManagedBean(value="loginBean")
//@ViewScoped
@Controller
public class LoginBean {

	private static Logger logger = Logger.getLogger(LoginBean.class);
	private String username;;
	private String password;

	@Autowired
	public HeaderNavigationBean headerNavigationBean;

	@Autowired
	private ILoginService loginService;


	public LoginBean() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws RestClientException, URISyntaxException,
			LoginException {

		AuthorRegistrationDto author = loginService.login(username, password);
		if (author != null) {

			OAuth2AccessToken accessToken = loginService.getoAuth2AccessToken();
			Map<String, Object> sessionMap = new HashMap<>();
			sessionMap.put("author", author);
			sessionMap.put("accessToken", accessToken);
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().putAll(sessionMap);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(
							"Login Successful, user and token in session"));

		}
		headerNavigationBean.setPage("profile");
		return "index";
	}

	public String logout() {
		// loginService.logout();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove("author");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove("accessToken");
		return "index";
	}

}
