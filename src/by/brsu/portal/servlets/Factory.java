/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import javax.servlet.http.HttpServletRequest;
import by.brsu.portal.PortalTechnicalException;

/**
 * @author Roman Ulezlo
 * 
 */
public class Factory {
	private String forwardURL;

	public Action create(String actionName, HttpServletRequest request) {
		Action actionInstance = null;
		try {
			ActionHandler handler = new ActionHandler(actionName);
			if (handler.getClassName() != "")
				try {
					actionInstance = (Action) Class.forName(
							handler.getClassName()).newInstance();
					forwardURL = handler.getForwardURL();
				} catch (Exception ex) {
					actionInstance = (Action) ShowMainPage.class.newInstance();
					forwardURL = handler.getErrorURL();
				}
			else {
				actionInstance = (Action) ShowMainPage.class.newInstance();
				forwardURL = handler.getErrorURL();
			}
		} catch (Exception e) {
			new PortalTechnicalException("Class 'ShowMainPage' not found");
		}
		return actionInstance;
	}

	public String getForwardURL() {
		return "/" + forwardURL;
	}
}
