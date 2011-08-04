/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

/**
 * @author Roman Ulezlo
 * 
 */
abstract public class BootstrapAction implements Action {
	public String NameReq() {
		return "index";
	}

	public Object Send() {
		return null;
	}

	public String perform() {
		return "index1.html";
	}
}
