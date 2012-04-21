/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.brsu.portal.user.UserDAO;
import by.brsu.portal.user.User;

public class ShowUserProf implements Action {
	private UserDAO DAO = new UserDAO();
	private List<User> listUser = DAO.findAllUser();
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		map.put("users", listUser);
		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}

}
