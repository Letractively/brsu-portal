package by.brsu.portal.servlets;

//import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.brsu.portal.user.Status;
import by.brsu.portal.user.User;
import by.brsu.portal.user.UserDAO;

public class AddUser implements Action {
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response){
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		int sex;
		Boolean sex0 = Boolean.valueOf(request.getParameter("sex0"));
		if (sex0) sex=0; else sex=1;
		user.setSex(sex);
		Status status = new Status();
		status.setIdStat(1);
		user.setStatus(status);
		user.setIdStat(1);
		UserDAO userdao = new UserDAO();
		userdao.createUser(user);
		map.put("user", user);
		return true;
	}
	
	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}
}
