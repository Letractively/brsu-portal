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
public interface IUserPositionHistoryDAO {
	/**
	 * Add record about user position in history
	 * 
	 * @param name
	 *            String - name of user position history
	 */
	public UserPositionHistory createUserPositionHistory(long idUser,
			Date date, long idPosition, long idProject);

	/**
	 * Delete user position history
	 * 
	 * @param id
	 *            - id project history
	 */
	public void deleteUserPositionHistory(long id);

	/**
	 * Find user position history by id
	 * 
	 * @param id
	 *            - id user position history
	 */
	public UserPositionHistory findUserPositionHistoryById(long id);

	/**
	 * Find user position history by id of user
	 * 
	 * @return list of user position history
	 */
	public List<UserPositionHistory> findUserPositionHistoryByIdUser(long idUser);

	/**
	 * Find user position history by date
	 * 
	 * @return list of user position history
	 */
	public List<UserPositionHistory> findUserPositionHistoryByDate(Date date);

	/**
	 * Find user position history by id of position
	 * 
	 * @return list of user position history
	 */
	public List<UserPositionHistory> findUserPositionHistoryByIdPosition(
			long idPosition);

	/**
	 * Find user position history by id of project
	 * 
	 * @return list of user position history
	 */
	public List<UserPositionHistory> findUserPositionHistoryByIdProject(
			long idProject);

	/**
	 * Find all users position history
	 * 
	 * @return list of user position history
	 */
	public List<UserPositionHistory> findAllUserPositionHistory();
}
