/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
/**
 *  @author Hraznykh_Pavel
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.brsu.portal.user.UserDAO;
import by.brsu.portal.user.User;

public class ShowFullUser implements Action {

	private UserDAO DAO = new UserDAO();
	private int id;
	private User listUserid;
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getParametersMap() {

		return map;
	}

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		id = Integer.parseInt(request.getParameter("id"));
		listUserid = DAO.findUserById(id);
		map.put("users_id", listUserid);
		return true;
	}

}
