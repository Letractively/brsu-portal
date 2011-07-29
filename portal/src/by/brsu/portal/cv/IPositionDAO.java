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
public interface IPositionDAO {
	/**
	 * Add position
	 * 
	 * @param name
	 *            String - name of position
	 * @throws PortalTechnicalException
	 */
	public Position createPosition(String name) throws PortalTechnicalException;

	/**
	 * Delete position
	 * 
	 * @param name
	 *            - name of position
	 * @throws PortalTechnicalException
	 */
	public void deletePosition(String name) throws PortalTechnicalException;

	/**
	 * Find position by id
	 * 
	 * @param id
	 *            - id of position
	 * @throws PortalTechnicalException
	 */
	public Position findPositionById(long id) throws PortalTechnicalException;

	/**
	 * Find position by name
	 * 
	 * @param name
	 *            - name of position
	 * @throws PortalTechnicalException
	 */
	public Position findPositionByName(String name)
			throws PortalTechnicalException;

	/**
	 * Finds all positions
	 * 
	 * @return list of positions
	 * @throws PortalTechnicalException
	 */
	public List<Position> findAllPosition() throws PortalTechnicalException;
}
