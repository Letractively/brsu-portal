/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import by.brsu.portal.project.Project;
import by.brsu.portal.project.ProjectDAO;

/**
 * @author Roman Ulezlo
 *
 */
public class ShowProjects implements Action{
	private ProjectDAO pDAO = new ProjectDAO();
	private List<Project> projects = pDAO.findAllProjects();
	private Map<String, Object> mp = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getParametersMap() {
		mp.put("projects",projects);
		return mp;
	}

	@Override
	public String perform() {
		return "/project1.jsp";
	}
}
