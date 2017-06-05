package in.brewcode.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication//(exclude={DispatcherServletAutoConfiguration.class})
//@Profile(value="dev")
public class AdminApplication {

	
	//private static Logger logger = Logger.getLogger(AdminApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	
		
	}
	


}
