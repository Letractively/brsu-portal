/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

import java.sql.Date;
import java.util.List;

import by.brsu.portal.PortalTechnicalException;

/**
 * @author Roman Ulezlo
 * 
 */
public interface IUserPositionHistoryDAO {
	/**
	 * Add record about user position in history
	 * 
	 * @param name
	 *            String - name of user position history
	 * @throws PortalTechnicalException 
	 */
	public UserPositionHistory createUserPositionHistory(long idUser,
			Date date, long idPosition, long idProject) throws PortalTechnicalException;

	/**
	 * Delete user position history
	 * 
	 * @param id
	 *            - id project history
	 * @throws PortalTechnicalException 
	 */
	public void deleteUserPositionHistory(long id) throws PortalTechnicalException;

	/**
	 * Find user position history by id
	 * 
	 * @param id
	 *            - id user position history
	 * @throws PortalTechnicalException 
	 */
	public UserPositionHistory findUserPositionHistoryById(long id) throws PortalTechnicalException;

	/**
	 * Finds user position histories by id of user
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findUserPositionHistoryByIdUser(long idUser) throws PortalTechnicalException;

	/**
	 * Finds user position histories by date
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findUserPositionHistoryByDate(Date date) throws PortalTechnicalException;

	/**
	 * Finds user position histories by id of position
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findUserPositionHistoryByIdPosition(
			long idPosition) throws PortalTechnicalException;

	/**
	 * Finds user position histories by id of project
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findUserPositionHistoryByIdProject(
			long idProject) throws PortalTechnicalException;

	/**
	 * Finds all users position histories
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findAllUserPositionHistory() throws PortalTechnicalException;
}
