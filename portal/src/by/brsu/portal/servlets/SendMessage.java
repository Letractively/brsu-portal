/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.brsu.portal.message.*;
import by.brsu.portal.user.User;


/**
 * @author Trutsik Eduard
 *
 */
public class SendMessage implements Action{
	private MessageDao mDao = new MessageDao();
	private Message msg = new Message();
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int priority;
		long idUserTo=mDao.findIdUserByEmail(request.getParameter("user"));
		if(idUserTo==0) {
			return false;		
		}
		Date date = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());		
		msg.setDate(sqlDate);
		msg.setIdUserTo(idUserTo);
		msg.setIdUserFrom(user.getId());	
		msg.setTitle(request.getParameter("subject"));
		msg.setText(request.getParameter("text"));
		priority=Integer.valueOf(request.getParameter("priority")).intValue();		
		msg.setPriority(priority);
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
