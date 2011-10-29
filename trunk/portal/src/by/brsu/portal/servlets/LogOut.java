/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Admin
 * 
 */
public class LogOut implements Action {

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			logout(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		Principal userPrincipal = request.getUserPrincipal();
		if (userPrincipal != null) {
			request.setAttribute("user", userPrincipal.getName());
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	@Override
	public Map<String, Object> getParametersMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
