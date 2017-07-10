package in.brewcode.admin.service;

import java.net.URISyntaxException;

import javax.security.auth.login.LoginException;

import in.brewcode.admin.AdminApplication;
import in.brewcode.admin.service.impl.LoginServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={AdminApplication.class})
public class LoginTest {

	@Test
public void loginTest() throws LoginException, URISyntaxException{
		LoginServiceImpl loginService = new LoginServiceImpl();
		loginService.login("brewcode", "password");
	}
}
