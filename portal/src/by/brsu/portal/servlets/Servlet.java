/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Roman Ulezlo
 * 
 */

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
		String actionName = request.getRequestURI().substring(
				request.getContextPath().length());
		if (actionName != null && !"".equals(actionName)
				&& !"/".equals(actionName))
			return actionName.substring(actionName.lastIndexOf("/") + 1,
					actionName.length());
		return null;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Action action = factory.create(getActionName(request));
		for (Entry<String, Object> entry: action.getParametersMap(request, response).entrySet()){
			request.setAttribute(entry.getKey(),entry.getValue());
			}
		String url = action.perform(request,response);
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
