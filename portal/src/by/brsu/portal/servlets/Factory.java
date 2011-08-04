/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Ulezlo
 * 
 */
public class Factory {
	protected Map<String, Class<?>> map = defaultMap();

	public Factory() {
		super();
	}

	public Action create(String actionName) {
		Class<?> klass = (Class<?>) map.get(actionName);
		if (klass == null)
			throw new RuntimeException(getClass()
					+ " was unable to find an action named '"
					+ actionName + "'.");
		;

		Action actionInstance = null;
		try {
			actionInstance = (Action) klass.newInstance();
		} catch (Exception e) {
		}

		return actionInstance;
	}

	protected Map<String, Class<?>> defaultMap() {
		Map<String, Class<?>> map = new HashMap<String, Class<?>>();
		map.put("index", BootstrapAction.class);
		map.put("show", showNews.class);
		return map;
	}
}
