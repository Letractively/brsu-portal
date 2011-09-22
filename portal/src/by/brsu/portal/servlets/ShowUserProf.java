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
	private List<User> listuser  = DAO.FindAllUser();
	private Map<String, Object> ma_p = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response){
		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		ma_p.put("users", listuser);
		return ma_p;
	}

}
