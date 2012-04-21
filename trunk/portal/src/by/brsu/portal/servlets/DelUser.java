package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.brsu.portal.user.User;
import by.brsu.portal.user.UserDAO;

public class DelUser implements Action {

	private UserDAO DAO = new UserDAO();
	private User user;
	private Map<String, Object> map = new HashMap<String, Object>();
	int id;

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		id = Integer.parseInt(request.getParameter("id"));
		user = DAO.deleteUser(id);
		map.put("user", "");

		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		// TODO Auto-generated method stub
		return map;
	}
}
