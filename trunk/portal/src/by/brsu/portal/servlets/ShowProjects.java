/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.brsu.portal.project.Project;
import by.brsu.portal.project.ProjectDAO;

/**
 * @author Roman Ulezlo
 * 
 */
public class ShowProjects implements Action {
	private ProjectDAO pDAO = new ProjectDAO();
	private List<Project> projects = pDAO.findAllProjects();
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response){
		map.put("projects", projects);
		return true;
	}
	
	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}
}
