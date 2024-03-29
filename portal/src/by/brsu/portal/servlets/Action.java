/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Roman Ulezlo
 * 
 */
public interface Action {
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response)throws IOException;

public Map<String, Object> getParametersMap();

	
}
