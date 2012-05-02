/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import by.brsu.portal.user.User;

/**
 * @author Roman Ulezlo
 * 
 */

public class PermissionTag extends SimpleTagSupport {
	private String role;

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest httpRequest = (HttpServletRequest) pageContext
				.getRequest();
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("user");
		String[] roles = role.split(",");
		if (user != null) {
			for (int i = 0; i < role.split(",").length; i++) {
				if (roles[i].equals(user.getRole().name())) {
					getJspBody().invoke(null);
				}
			}
		}
	}

}
