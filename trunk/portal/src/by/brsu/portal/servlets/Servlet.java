package by.brsu.portal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Factory factory = new Factory();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected String getActionName(HttpServletRequest request) {
		String method = request.getRequestURI().substring(
				request.getContextPath().length());
		if (method != null && !"".equals(method) && !"/".equals(method))
			return method.substring(method.lastIndexOf("/") + 1,
					method.length());

		return null;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Servlet is called");
		Action action = factory.create(getActionName(request));
		request.setAttribute(action.nameReq(), action.send());
		String url = action.perform();
		if (url != null)
			getServletContext().getRequestDispatcher(url).forward(request,
					response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
