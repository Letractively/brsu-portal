package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.Map;

public class AddUser implements Action {
	private Map<String, Object> mp = new HashMap<String, Object>();

	@Override
	public String perform() {
		// TODO Auto-generated method stub
		return "/addUserOK.jsp";
	}

	@Override
	public Map<String, Object> getParametersMap() {
		mp.put("", "");
		return mp;
	}
}
