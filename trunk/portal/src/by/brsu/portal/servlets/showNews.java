/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

/**
 * @author Roman Ulezlo
 *
 */
public class showNews implements Action{
	public String NameReq() {
		return "news";
	}

	public Object Send() {
		return null;
	}

	public String perform() {
		return "news1.jsp";
	}
}
