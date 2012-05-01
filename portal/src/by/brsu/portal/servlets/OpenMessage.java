/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.brsu.portal.message.Message;
import by.brsu.portal.message.MessageDao;

/**
 * @author Thug
 *
 */
public class OpenMessage implements Action{
	private MessageDao mDao = new MessageDao();
	private Message msg = new Message();
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response){
		long idUser=0;
		String temp;
		try{
			msg=mDao.findMessageById(Long.valueOf(request.getParameter("idMessage")));
			msg.setReaded(1);
			temp=request.getParameter("idUserTo");
			if(temp==null)	{
				temp=request.getParameter("idUserFrom");
				idUser=Long.valueOf(temp);
			} else {
				idUser=Long.valueOf(temp);
				msg.setIdUserTo(idUser);
			}
			mDao.updateMessages(msg);
			map.put("message", msg);
			return true;
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		} 		
		return false;
	}
	
	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}

}
