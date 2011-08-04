/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

/**
 * @author Roman Ulezlo
 * 
 */
public interface Action {
	public String perform();

	public String nameReq();

	public Object send();
}
