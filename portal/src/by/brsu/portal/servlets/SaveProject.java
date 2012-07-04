/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.brsu.portal.cv.ProgrammingLanguageDAO;
import by.brsu.portal.cv.TechnologyDAO;
import by.brsu.portal.project.Project;
import by.brsu.portal.project.ProjectCategory;
import by.brsu.portal.project.ProjectCategoryDAO;
import by.brsu.portal.project.ProjectDAO;
import by.brsu.portal.user.User;
import by.brsu.portal.user.UserDAO;

/**
 * @author Elena Pechko
 *
 */
public class SaveProject implements Action
{
	private ProjectDAO projectDAO = new ProjectDAO();
	private Map<String, Object> map = new HashMap<String, Object>();
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		Project project = new Project();
		project.setIdProject(Long.parseLong(request.getParameter("id")));
		project.setName(request.getParameter("name"));
		project.setDescription(request.getParameter("description"));
		project.setLicense(request.getParameter("license"));
		project.setStageOfDevelopment(request
				.getParameter("stageOfDevelopment"));
		if (!"".equals(request.getParameter("version"))) {
			project.setVersion(Integer.parseInt(request.getParameter("version")));
		}
		return projectDAO.saveProject(project);
	}

	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}

}
