/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.brsu.portal.message.Message;
import by.brsu.portal.message.MessageDao;

/**
 * @author Trutsik Eduard
 *
 */
public class SentMessages implements Action {
	private MessageDao messageDao = new MessageDao();
	private List<Message> messages;
	private Map<String, Object> mp = new HashMap<String, Object>();
	
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response){
		messages = messageDao.findAllMessageUserFrom(2); //idUserFrom
		if(messages!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public Map<String, Object> getParametersMap() {
		mp.put("messages", messages);
		return mp;
	}

}
