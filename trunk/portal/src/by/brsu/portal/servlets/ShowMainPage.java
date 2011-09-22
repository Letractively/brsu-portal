/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Roman Ulezlo
 * 
 */
public class ShowMainPage implements Action {
	private Map<String, Object> mp = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response){
		return true;
	}
	
	@Override
	public Map<String, Object> getParametersMap(HttpServletRequest request,
			HttpServletResponse response) {
		mp.put("", "");
		return mp;
	}
}
