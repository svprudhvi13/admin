package in.brewcode.admin.model;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
//Using CDI annotation instead of JSF annotation for maintainence in future
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

	private static Logger logger = Logger.getLogger(LoginBean.class);
	private String username;
	private String password;
	
	public LoginBean() {
	}

	public String login(){
		
		logger.info("inside login method "+ this.username);
		
		return "index";
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
}
