/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

import java.util.List;

/**
 * @author Roman Ulezlo
 * 
 */
public interface ITechnologyDAO {
	/**
	 * Add technology
	 * 
	 * @param name
	 *            String - name of technology
	 */
	public Technology createTechnology(String name);

	/**
	 * Delete technology
	 * 
	 * @param name
	 *            - name of technology
	 */
	public void deleteTechnology(String name);

	/**
	 * Find technology by id
	 * 
	 * @param id - id of technology
	 */
	public Technology findTechnologyById(long id);

	/**
	 * Find technology by name
	 * 
	 * @param name
	 *            - name of technology
	 */
	public Technology findTechnologyByName(String name);

	/**
	 * Find all technologies
	 * 
	 * @return list of technologies
	 */
	public List<Technology> findAllTechologies();
}
