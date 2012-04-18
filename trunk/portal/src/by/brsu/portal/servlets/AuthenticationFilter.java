/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.brsu.portal.user.User;

/**
 * @author Roman Ulezlo
 * 
 */
public class AuthenticationFilter implements Filter {

	public void destroy() {
	}

	protected String getActionName(HttpServletRequest request) {
		String actionName = request.getRequestURI().substring(
				request.getContextPath().length());
		if (actionName != null && !"".equals(actionName)
				&& !"/".equals(actionName))
			return actionName.substring(actionName.lastIndexOf("/") + 1,
					actionName.length());
		return null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			((HttpServletResponse) response).sendRedirect("/portal/login.jsp");
			return;
		} else {
			ActionHandler handler = new ActionHandler(
					getActionName(httpRequest));
			List<String> roles = handler.getRoles();
			for (String role : roles) {
				if (role.equals(user.getRole().name())) {
					chain.doFilter(request, (HttpServletResponse) response);
					return;
				}
			}
		}
		((HttpServletResponse) response).sendRedirect("/portal/errorPage.jsp");
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
