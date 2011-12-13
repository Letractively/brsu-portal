/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

import java.util.List;

import by.brsu.portal.PortalTechnicalException;

/**
 * @author Roman Ulezlo
 * 
 */
public interface IProjectHistoryDAO {
	/**
	 * Add record about project in history
	 * 
	 * @param name
	 *            String - name of project history
	 * @throws PortalTechnicalException
	 */
	public ProjectHistory createProjectHistory(long project, long user,
			String stage, String name) throws PortalTechnicalException;

	/**
	 * Delete project history
	 * 
	 * @param id
	 *            - id project history
	 * @throws PortalTechnicalException
	 */
	public void deleteProjectHistory(long id) throws PortalTechnicalException;

	/**
	 * Find project history by id
	 * 
	 * @param id
	 *            - id project history
	 * @throws PortalTechnicalException
	 */
	public ProjectHistory findProjectHistoryById(long id)
			throws PortalTechnicalException;

	/**
	 * Finds project histories by id of user
	 * 
	 * @return list of project history
	 * @throws PortalTechnicalException
	 */
	public List<ProjectHistory> findProjectHistoryByIdUser(long idUser)
			throws PortalTechnicalException;

	/**
	 * Finds project histories by id of project
	 * 
	 * @return list of project history
	 * @throws PortalTechnicalException
	 */
	public List<ProjectHistory> findProjectHistoryByIdProject(long idProject)
			throws PortalTechnicalException;

	/**
	 * Finds project histories by name
	 * 
	 * @return list of project history
	 * @throws PortalTechnicalException
	 */
	public List<ProjectHistory> findProjectHistoryByName(String name)
			throws PortalTechnicalException;

	/**
	 * Finds project histories by stage
	 * 
	 * @return list of project history
	 * @throws PortalTechnicalException
	 */
	public List<ProjectHistory> findProjectHistoryByStage(String name)
			throws PortalTechnicalException;

	/**
	 * Finds all project histories by stage
	 * 
	 * @return list of project history
	 * @throws PortalTechnicalException
	 */
	public List<ProjectHistory> findAllProjectHistory()
			throws PortalTechnicalException;
}
