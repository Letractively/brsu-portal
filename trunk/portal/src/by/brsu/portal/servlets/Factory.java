/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Roman Ulezlo
 * 
 */
public class Factory {
	public Factory() {
	}

	public Action create(String actionName,HttpServletRequest request) {
		Action actionInstance = null;
		try {
			ActionHandler handler = new ActionHandler(actionName);
			if (handler.getClassName() != "")
				try {
					actionInstance = (Action) Class.forName(handler.getClassName()).newInstance();
				} catch (Exception ex) {
					actionInstance = (Action) ShowMainPage.class.newInstance();
				}
			else
				actionInstance = (Action) ShowMainPage.class.newInstance();
		} catch (Exception e) {
		}
		return actionInstance;
	}
}
