package by.brsu.portal.servlets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		Date date = new Date();
		 String strDate = request.getParameter("dateofbirth");
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         try {
		 date = format.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());         
        
        user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setSex(Integer.parseInt(request.getParameter("sex")));
		user.setDateOfBirth(sqlDate);	
		user.setTelephone(request.getParameter("telephone"));
		user.setSkype(request.getParameter("skype"));
		user.setIcq(request.getParameter("icq"));
		//user.setPicture(request.getParameterValues("picture"));
		user.setAbout(request.getParameter("about"));
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
