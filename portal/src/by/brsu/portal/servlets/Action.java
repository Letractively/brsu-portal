/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.Map;

/**
 * @author Roman Ulezlo
 * 
 */
public interface Action {
	public String perform();

	public Map<String, Object> getParametersMap();
}
