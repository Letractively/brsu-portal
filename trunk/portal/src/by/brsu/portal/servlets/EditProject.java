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
import by.brsu.portal.project.ProjectCategoryDAO;
import by.brsu.portal.project.ProjectDAO;
import by.brsu.portal.user.UserDAO;

/**
 * @author Elena Pechko
 *
 */
public class EditProject implements Action
{
	private ProgrammingLanguageDAO plDAO = new ProgrammingLanguageDAO();
	private TechnologyDAO tDAO = new TechnologyDAO();
	private UserDAO uDAO = new UserDAO();
	private ProjectDAO pDAO = new ProjectDAO();
	private ProjectCategoryDAO pcDAO = new ProjectCategoryDAO();
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		map.put("projectCategory", pcDAO.findAllProjectCategory());
		map.put("languages", plDAO.findAllLanguages());
		map.put("technologies", tDAO.findAllTechologies());
		Project project = pDAO.findProjectById(Long.parseLong(request.getParameter("id")));
		map.put("owner", uDAO.findUserById(project.getUser()));		
		map.put("project", project);		
		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}

}
