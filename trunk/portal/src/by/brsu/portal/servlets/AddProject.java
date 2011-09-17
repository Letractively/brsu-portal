/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.brsu.portal.cv.ProgrammingLanguage;
import by.brsu.portal.cv.Technology;
import by.brsu.portal.project.Project;
import by.brsu.portal.project.ProjectCategory;
import by.brsu.portal.project.ProjectDAO;

/**
 * @author Artur Smaliuk
 * 
 */
public class AddProject implements Action {
	private Map<String, Object> map = new HashMap<String, Object>();
	Project project = new Project();

	@Override
	public Map<String, Object> getParametersMap(HttpServletRequest request,
			HttpServletResponse response) {
		ProjectCategory pc = new ProjectCategory();
		project.setName(request.getParameter("name"));
		project.setDescription(request.getParameter("description"));
		pc.setName(request.getParameter("category"));
		project.setCategory(pc);
		project.setLicense(request.getParameter("license"));
		project.setStageOfDevelopment(request
				.getParameter("stageOfDevelopment"));
		Technology tech = new Technology();
		tech.setName(request.getParameter("technology"));
		List<Technology> th = new ArrayList<Technology>();
		th.add(tech);
		project.setTechnology(th);
		ProgrammingLanguage progl = new ProgrammingLanguage();
		progl.setName(request.getParameter("languages"));
		List<ProgrammingLanguage> pl = new ArrayList<ProgrammingLanguage>();
		pl.add(progl);
		project.setLanguages(pl);

		ProjectDAO ppp = new ProjectDAO();
		ppp.createProject(project);

		// return "/addProjectOK.jsp";
		map.put("project", project);
		return map;
	}
}
