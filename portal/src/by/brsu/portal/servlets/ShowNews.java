/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.brsu.portal.news.News;
import by.brsu.portal.news.NewsDAO;

/**
 * @author Roman Ulezlo
 * 
 */
public class ShowNews implements Action {
	private NewsDAO nDAO = new NewsDAO();
	private List<News> news;
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		news = nDAO.readNews();
		return true;
	}
	
	@Override
	public Map<String, Object> getParametersMap() {
		
		map.put("news", news);
		return map;
	}
}
