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
public interface IProjectCategoryDAO {
	/**
	 * Add category project
	 * 
	 * @param name
	 *            String - name of category project
	 */
	public ProjectCategory createProjectCategory(String name);

	/**
	 * Delete category project
	 * 
	 * @param name
	 *            - name of category project
	 */
	public void deleteProjectCategory(String name);

	/**
	 * Find category project by id
	 * 
	 * @param id
	 *            - id of category project
	 */
	public ProjectCategory findProjectCategoryById(long id);

	/**
	 * Find category project by name
	 * 
	 * @param name
	 *            - name of category project
	 */
	public ProjectCategory findProjectCategoryByName(String name);

	/**
	 * Find all categories of project
	 * 
	 * @return list of categories of project
	 */
	public List<ProjectCategory> findAllProjectCategory();
}
