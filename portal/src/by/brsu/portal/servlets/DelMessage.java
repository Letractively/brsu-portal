/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.brsu.portal.message.Message;
import by.brsu.portal.message.MessageDao;
import by.brsu.portal.user.User;

/**
 * @author Thug
 *
 */
public class DelMessage implements Action {
	private MessageDao mDao = new MessageDao();
	private Message msg = new Message();
	private String idMessages[];
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		try {			
			idMessages=request.getParameterValues("idMessage");
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null && idMessages != null) {
				for (String idMessage : idMessages) {
					mDao.delMessage(Long.valueOf(idMessage).longValue(), user.getId());
				}
			}
		map.put("message", msg);
		return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}

}
