/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.brsu.portal.cv.PositionDAO;
import by.brsu.portal.cv.ProgrammingLanguage;
import by.brsu.portal.cv.ProgrammingLanguageDAO;
import by.brsu.portal.cv.Technology;
import by.brsu.portal.cv.TechnologyDAO;
import by.brsu.portal.project.Link;
import by.brsu.portal.project.Project;
import by.brsu.portal.project.ProjectCategory;
import by.brsu.portal.project.ProjectCategoryDAO;
import by.brsu.portal.project.ProjectDAO;
import by.brsu.portal.user.UserDAO;

/**
 * @author Artur Smaliuk, Roman Ulezlo
 * 
 */
public class SaveNewProject implements Action {
	private Map<String, Object> map = new HashMap<String, Object>();
	private UserDAO uDAO = new UserDAO();
	
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Project project = new Project();
		project.setName(request.getParameter("name"));
		project.setUser(Integer.parseInt(request.getParameter("owner")));
		project.setDescription(request.getParameter("description"));
		project.setLicense(request.getParameter("license"));
		project.setStageOfDevelopment(request
				.getParameter("stageOfDevelopment"));
		if (!"".equals(request.getParameter("version"))) {
			project.setVersion(Integer.parseInt(request.getParameter("version")));
		}
		ProjectCategory projectCategory = new ProjectCategory();
		ProjectCategoryDAO projectCategoryDAO = new ProjectCategoryDAO();
		projectCategory = projectCategoryDAO.findProjectCategoryById(Long
				.parseLong(request.getParameter("projectCategory")));
		project.setCategory(projectCategory);

		String[] idTechnology = request.getParameterValues("technology");
		TechnologyDAO technologyDAO = new TechnologyDAO();
		if (idTechnology != null) {
			for (int i = 0; i < idTechnology.length; i++) {
				Technology technology = new Technology();
				technology = technologyDAO.findTechnologyById(Long
						.parseLong(idTechnology[i]));
				project.getTechnology().add(technology);
			}
		}
		String[] idProgramminglanguages = request
				.getParameterValues("language");
		ProgrammingLanguageDAO programmingLanguageDAO = new ProgrammingLanguageDAO();
		if (idProgramminglanguages != null) {
			for (int i = 0; i < idProgramminglanguages.length; i++) {
				ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
				programmingLanguage = programmingLanguageDAO.findProgrammingLanguageById(Long
						.parseLong(idProgramminglanguages[i]));
				project.getLanguages().add(programmingLanguage);
			}
		}
		String[] links = request.getParameterValues("list1");
		if (links!=null){
			for (int i =0 ;i < links.length; i++){
				Link link = new Link();
				link.setName(links[i]);
				link.setProject(project);
				project.getLinks().add(link);
			}
		}
		ProjectDAO projectDAO = new ProjectDAO();
		project = projectDAO.createProject(project);
		map.put("project", project.getIdProject());
		map.put("participants", uDAO.findAllUser());
		map.put("positions", (new PositionDAO()).findAllPosition());
		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}
}
