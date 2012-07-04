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
public class SendMessage implements Action {
	private MessageDao mDao;
	private Message msg;
	private UserDAO userDao;
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		userDao = new UserDAO();
		mDao = new MessageDao();
		msg = new Message();
		int priorityValue;
		String userTo = request.getParameter("userTo");
		String subject = request.getParameter("subject");
		String text = request.getParameter("text");
		String priority = request.getParameter("priority");
		long idUserTo = mDao.findIdUserByEmail(userTo);
		if (idUserTo == 0) {
			map.put("error",
					String.format(
							"There is no such an user to send message to: '%s'",
							userTo));
			map.put("userTo", userTo);
			map.put("subject", subject);
			map.put("text", text);
			map.put("prioritys", mDao.findAllPriority());
			return false;
		}
		Date date = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		msg.setDate(sqlDate);
		msg.setUserTo(userDao.findUserById(idUserTo));
		msg.setUserFrom(user);
		msg.setTitle(subject);
		msg.setText(text);
		priorityValue = Integer.valueOf(priority).intValue();
		msg.setPriority(priorityValue);
		msg.setReaded(0);
		msg.setPrevious(0); // I don't no
		mDao.creatMessages(msg);
		map.put("message", msg);
		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}

}
