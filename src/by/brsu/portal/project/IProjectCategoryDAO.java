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
public interface IProjectCategoryDAO {
	/**
	 * Add category project
	 * 
	 * @param name
	 *            String - name of category project
	 * @throws PortalTechnicalException
	 */
	public ProjectCategory createProjectCategory(String name)
			throws PortalTechnicalException;

	/**
	 * Delete category project
	 * 
	 * @param name
	 *            - name of category project
	 * @throws PortalTechnicalException
	 */
	public void deleteProjectCategory(String name)
			throws PortalTechnicalException;

	/**
	 * Find category project by id
	 * 
	 * @param id
	 *            - id of category project
	 * @throws PortalTechnicalException
	 */
	public ProjectCategory findProjectCategoryById(long id)
			throws PortalTechnicalException;

	/**
	 * Find category project by name
	 * 
	 * @param name
	 *            - name of category project
	 * @throws PortalTechnicalException
	 */
	public ProjectCategory findProjectCategoryByName(String name)
			throws PortalTechnicalException;

	/**
	 * Finds all categories of project
	 * 
	 * @return list of categories of project
	 * @throws PortalTechnicalException
	 */
	public List<ProjectCategory> findAllProjectCategory()
			throws PortalTechnicalException;
}
