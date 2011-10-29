/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Admin
 *
 */
public class Login implements Action{

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login");
		String remoteUser = request.getRemoteUser();
		if (remoteUser!=null){
			System.out.println("remoteUser "+remoteUser);
			request.getSession().setAttribute("user", remoteUser);
			redirect (request, response);
		}else{
			Object user= request.getParameter("username");
			Object password= request.getParameter("password");
			System.out.println("user "+user);
			System.out.println("password "+password);
			if (user!=null && password!=null){
				String userName = user.toString();
				if (authenticate(userName,password.toString())){
					request.getSession().setAttribute("user", userName);
					redirect(request, response);
				}else{
					request.setAttribute("err", "Access denied. Try to login again.");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}
		}
	}
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void redirect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login->redirected to showStudents");
		//request.getRequestDispatcher("/loginOK.jsp").forward(request, response);
	}
	private boolean authenticate(String user, String password) {
		return "admin".equals(user) && "123".equals(password);
	}
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			doLogin(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
