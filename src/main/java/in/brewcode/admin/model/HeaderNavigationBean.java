package in.brewcode.admin.model;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@ManagedBean(name="headerNavigationBean", eager=true)
//@SessionScoped
@Component
@Scope
public class HeaderNavigationBean {

	
	private static final Logger LOG = Logger
			.getLogger(HeaderNavigationBean.class);
private static final String PATH_TO_PAGES =	"/templates/pages/";
private String page=PATH_TO_PAGES+"login";
public String getPage() {
	return page;
}


public void setPage(String page) {
	this.page=PATH_TO_PAGES+page;
	}




}
