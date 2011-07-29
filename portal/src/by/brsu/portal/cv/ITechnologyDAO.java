/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

import java.util.List;

import by.brsu.portal.PortalTechnicalException;

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
	 * @throws PortalTechnicalException
	 */
	public Technology createTechnology(String name)
			throws PortalTechnicalException;

	/**
	 * Delete technology
	 * 
	 * @param name
	 *            - name of technology
	 * @throws PortalTechnicalException
	 */
	public void deleteTechnology(String name) throws PortalTechnicalException;

	/**
	 * Find technology by id
	 * 
	 * @param id
	 *            - id of technology
	 * @throws PortalTechnicalException
	 */
	public Technology findTechnologyById(long id)
			throws PortalTechnicalException;

	/**
	 * Find technology by name
	 * 
	 * @param name
	 *            - name of technology
	 * @throws PortalTechnicalException
	 */
	public Technology findTechnologyByName(String name)
			throws PortalTechnicalException;

	/**
	 * Finds all technologies
	 * 
	 * @return list of technologies
	 * @throws PortalTechnicalException
	 */
	public List<Technology> findAllTechologies()
			throws PortalTechnicalException;
}
