/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.List;

import by.brsu.portal.news.News;
import by.brsu.portal.news.NewsDAO;

/**
 * @author Roman Ulezlo
 * 
 */
public class showNews implements Action {
	NewsDAO nDAO = new NewsDAO();
	List<News> news = nDAO.readNews();

	public String nameReq() {
		return "news";
	}

	public Object send() {
		return news;
	}

	public String perform() {
		return "/" + "news1.jsp";
	}
}
