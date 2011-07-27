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
public interface IPositionDAO {
	/**
	 * Add position
	 * 
	 * @param name
	 *            String - name of position
	 */
	public Position createPosition(String name);
	
	/**
	 * Delete position
	 * 
	 * @param name
	 *            - name of position
	 */
	public void deletePosition(String name);
	
	/**
	 * Find position by id
	 * 
	 * @param id
	 *            - id of position
	 */
	public Position findPositionById(long id);
	
	/**
	 * Find position by name
	 * 
	 * @param name
	 *            - name of position
	 */
	public Position findPositionByName(String name);
	
	/**
	 * Find all positions
	 * 
	 * @return list of positions
	 */
	public List<Position> findAllPosition();
}
