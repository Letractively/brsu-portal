package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUser implements Action {
	private Map<String, Object> mp = new HashMap<String, Object>();

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		return "/addUserOK.jsp";
	}

	@Override
	public Map<String, Object> getParametersMap(HttpServletRequest request,
			HttpServletResponse response) {
		mp.put("", "");
		return mp;
	}
}
