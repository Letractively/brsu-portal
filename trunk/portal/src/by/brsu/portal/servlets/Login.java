/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.brsu.portal.user.User;
import by.brsu.portal.user.UserDAO;

/**
 * @author Roman Ulezlo
 * 
 */
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean error = false;

		if (email.length() == 0 || email == null) {
			error = true;
			request.setAttribute("loginError", "User name is required");
		}

		if (password.length() == 0 || password == null) {
			error = true;
			request.setAttribute("passwordError", "Password is required");
		}

		UserDAO userDAO = new UserDAO();
		User user = userDAO.findUserByEmailAndPassword(email, password);

		if (user == null) {
			error = true;
			request.setAttribute("loginError", "User name is  wrong");
			request.setAttribute("passwordError", "Password is  wrong");
		}

		if (error) {
			RequestDispatcher view = request
					.getRequestDispatcher("/errorLogin.jsp");
			view.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
