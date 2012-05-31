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
import by.brsu.portal.project.ProjectCategoryDAO;
import by.brsu.portal.user.UserDAO;

/**
 * @author Artur Smaliuk, Roman Ulezlo
 *
 */
public class AddNewProject implements Action
{
	private ProgrammingLanguageDAO plDAO = new ProgrammingLanguageDAO();
	private TechnologyDAO tDAO = new TechnologyDAO();
	private UserDAO uDAO = new UserDAO();
	private ProjectCategoryDAO pDAO = new ProjectCategoryDAO();
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		map.put("projectCategory", pDAO.findAllProjectCategory());
		map.put("languages", plDAO.findAllLanguages());
		map.put("technology", tDAO.findAllTechologies());
		map.put("owner", uDAO.findAllUser());		
		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}

}
