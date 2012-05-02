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
import by.brsu.portal.message.MessageDao;

/**
 * @author Trutsik Eduard
 *
 */

public class NewMessage implements Action {
	private MessageDao messageDao = new MessageDao();
	private List<Long> prioritys;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response){
		prioritys=messageDao.findAllPriority();
		if(prioritys!=null) {
			map.put("prioritys", prioritys);
			return true;
		}
		return false;
	}
	
	@Override
	public Map<String, Object> getParametersMap() {		
		return map;
	}

}
