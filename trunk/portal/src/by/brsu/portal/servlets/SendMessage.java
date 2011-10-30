/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.brsu.portal.message.*;


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
		int priority;
		long idToUser=mDao.findIdByLogin(request.getParameter("user"));
		if(idToUser==0) return false;		
		Date date = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		msg.setDate(sqlDate);
		msg.setIdToUser(idToUser);
		msg.setIdFromUser(idToUser); // idFromUser!!!		
		msg.setTitle(request.getParameter("subject"));
		msg.setText(request.getParameter("text"));
		priority=Integer.valueOf(request.getParameter("priority")).intValue();		
		msg.setPriority(priority);
		msg.setReaded(0);		
		msg.setPrevious(0);
		mDao.creatMessages(msg);
		map.put("message", msg);
		return true;
	}
	
	@Override
	public Map<String, Object> getParametersMap() {
		map.put("message", msg);
		return map;
	}

}
