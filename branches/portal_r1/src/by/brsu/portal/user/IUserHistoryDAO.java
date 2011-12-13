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
public interface IUserHistoryDAO {
	/**
	 * Add record about user in history
	 * 
	 * @param name
	 *            String - name of user history
	 * @throws PortalTechnicalException 
	 */
	public UserHistory createUserHistory(long idUser, java.sql.Date date,
			String name, String surname, long idStatus, int iq,
			int numberOfCations) throws PortalTechnicalException;
	
	/**
	 * Delete user history
	 * 
	 * @param id
	 *            - id user history
	 * @throws PortalTechnicalException 
	 */
	public void deleteUserHistory(long id) throws PortalTechnicalException;
	
	/**
	 * Find user history by id
	 * 
	 * @param id
	 *            - id user history
	 * @throws PortalTechnicalException 
	 */
	public UserHistory findUserHistoryById(long id) throws PortalTechnicalException;
	
	/**
	 * Finds user histories by id of user
	 * 
	 * @return list of user history
	 * @throws PortalTechnicalException 
	 */
	public List<UserHistory> findUserHistoryByIdUser(long idUser) throws PortalTechnicalException;
	
	/**
	 * Finds user histories by date
	 * 
	 * @return list of user history
	 * @throws PortalTechnicalException 
	 */
	public List<UserHistory> findUserHistoryByDate(Date date) throws PortalTechnicalException;
	
	/**
	 * Finds user histories by name
	 * 
	 * @return list of user history
	 * @throws PortalTechnicalException 
	 */
	public List<UserHistory> findUserHistoryByName(String name) throws PortalTechnicalException;
	
	/**
	 * Finds user histories by surname
	 * 
	 * @return list of user history
	 * @throws PortalTechnicalException 
	 */
	public List<UserHistory> findUserHistoryBySurame(String surname) throws PortalTechnicalException;
	
	/**
	 * Find user history by id of status
	 * 
	 * @return list of user history
	 * @throws PortalTechnicalException 
	 */
	public List<UserHistory> findUserHistoryByIdStatus(int status) throws PortalTechnicalException;
	
	/**
	 * Finds user histories by IQ
	 * 
	 * @return list of user history
	 * @throws PortalTechnicalException 
	 */
	public List<UserHistory> findUserHistoryByIq(int iq) throws PortalTechnicalException;
	
	/**
	 * Finds user histories by number of cations
	 * 
	 * @return list of user history
	 * @throws PortalTechnicalException 
	 */
	public List<UserHistory> findUserHistoryByNumberOfCations(int numberOfCations) throws PortalTechnicalException;
	
	/**
	 * Finds all user history
	 * 
	 * @return list of user history
	 * @throws PortalTechnicalException 
	 */
	public List<UserHistory> findAllUserHistory() throws PortalTechnicalException;	
}
