/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Roman Ulezlo
 * 
 */
public interface Action {
	public String perform(HttpServletRequest request,
			HttpServletResponse response);

	public Map<String, Object> getParametersMap(HttpServletRequest request,
			HttpServletResponse response);
}
