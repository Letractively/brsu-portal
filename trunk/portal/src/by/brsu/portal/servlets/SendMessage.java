/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.brsu.portal.message.*;
import by.brsu.portal.user.User;
import by.brsu.portal.user.UserDAO;


/**
 * @author Trutsik Eduard
 *
 */
public class SendMessage implements Action{
	private MessageDao mDao;
	private Message msg;
	private UserDAO userDao;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		userDao = new UserDAO();
		mDao = new MessageDao();
		msg = new Message();
		int priority;
		try {
			long idUserTo = mDao.findIdUserByEmail(request.getParameter("user"));
			if (idUserTo == 0) {
				return false;
			}
			Date date = new Date(System.currentTimeMillis());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			msg.setDate(sqlDate);
			msg.setUserTo(userDao.findUserById(idUserTo));
			msg.setUserFrom(user);
			msg.setTitle(request.getParameter("subject"));
			msg.setText(request.getParameter("text"));
			priority = Integer.valueOf(request.getParameter("priority")).intValue();
			msg.setPriority(priority);
			msg.setReaded(0);
			msg.setPrevious(0); // I don't no
			mDao.creatMessages(msg);
			map.put("message", msg);
		return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Map<String, Object> getParametersMap() {		
		return map;
	}

}
