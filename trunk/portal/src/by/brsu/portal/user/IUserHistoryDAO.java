/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

import java.sql.Date;
import java.util.List;

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
	 */
	public UserHistory createUserHistory(long idUser, java.sql.Date date,
			String name, String surname, long idStatus, int iq,
			int numberOfCations);
	
	/**
	 * Delete user history
	 * 
	 * @param id
	 *            - id user history
	 */
	public void deleteUserHistory(long id);
	
	/**
	 * Find user history by id
	 * 
	 * @param id
	 *            - id user history
	 */
	public UserHistory findUserHistoryById(long id);
	
	/**
	 * Find user history by id of user
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByIdUser(long idUser);
	
	/**
	 * Find user history by date
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByDate(Date date);
	
	/**
	 * Find user history by name
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByName(String name);
	
	/**
	 * Find user history by name
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryBySurame(String surname);
	
	/**
	 * Find user history by id of status
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByIdStatus(int status);
	
	/**
	 * Find user history by IQ
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByIq(int iq);
	
	/**
	 * Find user history by number of cations
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByNumberOfCations(int numberOfCations);
	
	/**
	 * Find all user history
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findAllUserHistory();	
}
