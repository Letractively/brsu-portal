/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

import java.util.List;

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
	 */
	public ProjectHistory createProjectHistory(long project, long user,
			String stage, String name);
	
	/**
	 * Delete project history
	 * 
	 * @param id
	 *            - id project history
	 */
	public void deleteProjectHistory(long id);
	
	/**
	 * Find project history by id
	 * 
	 * @param id
	 *            - id project history
	 */
	public ProjectHistory findProjectHistoryById(long id);
	
	/**
	 * Find project history by id of user
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findProjectHistoryByIdUser(long idUser);
	
	/**
	 * Find project history by id of project
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findProjectHistoryByIdProject(long idProject);
	
	/**
	 * Find project history by name
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findProjectHistoryByName(String name);
	
	/**
	 * Find project history by stage
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findProjectHistoryByStage(String name);
	
	/**
	 * Find all project history by stage
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findAllProjectHistory();
}
