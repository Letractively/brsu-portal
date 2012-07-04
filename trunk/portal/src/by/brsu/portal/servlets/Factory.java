/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/**
 * @author Roman Ulezlo
 * 
 */
public class Factory {
	private String forwardURL;
	private String errorURL;
	private static final Logger log = Logger.getLogger(Factory.class);

	public Action create(String actionName, HttpServletRequest request)
			throws IOException {
		Action actionInstance = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			ActionHandler handler = new ActionHandler(actionName);
			if (handler.getClassName() != "")
				try {
					actionInstance = (Action) Class.forName(
							handler.getClassName()).newInstance();
					forwardURL = handler.getForwardURL();
					errorURL = handler.getErrorURL();
				} catch (Exception ex) {
					actionInstance = (Action) ShowMainPage.class.newInstance();
					forwardURL = handler.getErrorURL();
					errorURL = handler.getErrorURL();
				}
			else {
				actionInstance = (Action) ShowMainPage.class.newInstance();
				forwardURL = handler.getErrorURL();
				errorURL = handler.getErrorURL();
			}
		} catch (Exception e) {
			log.error(e);
		}
		return actionInstance;
	}

	public String getForwardURL() {
		return "/" + forwardURL;
	}

	public String getErrorURL() {
		return "/" + errorURL;
	}
	
}
