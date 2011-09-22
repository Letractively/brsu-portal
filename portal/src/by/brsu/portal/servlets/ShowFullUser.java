/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
/**
 *  @author Hraznykh_Pavel
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.brsu.portal.user.UserDAO;
import by.brsu.portal.user.User;

public class ShowFullUser implements Action {

	private UserDAO DAO = new UserDAO();
	private int id;
	private User listuser_id;
	private Map<String, Object> ma_p = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getParametersMap(HttpServletRequest request,
			HttpServletResponse response) {
		id = Integer.parseInt(request.getParameter("id"));
		listuser_id = DAO.findUserById(id);
		ma_p.put("users_id", listuser_id);
		return ma_p;
	}

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		return true;
	}

}
