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
public class DelMessage implements Action {
	private MessageDao mDao = new MessageDao();
	private Message msg = new Message();
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getParametersMap() {
		map.put("message", msg);
		return null;
	}

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		msg.setId(Long.valueOf(request.getParameter("messageId")).longValue());
		mDao.delMessage(msg.getId());
		return false;
	}

}
