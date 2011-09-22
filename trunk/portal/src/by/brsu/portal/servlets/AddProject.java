/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		project.setName(request.getParameter("name"));
		project.setUser(Integer.parseInt(request.getParameter("owner")));
		project.setDescription(request.getParameter("description"));
		/*DateFormat dateFormat = DateFormat.getDateInstance();
		Date date = null;
		try {
			date = dateFormat.parse(request.getParameter("datecr"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project.setDateOfCreation(date);
		try {
			date = dateFormat.parse(request.getParameter("datecl"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project.setDateOfClosing(date);*/
		ProjectCategory pc = new ProjectCategory();
		pc.setName(request.getParameter("category"));
		project.setCategory(pc);
		project.setVersion(Integer.parseInt(request.getParameter("version")));
		project.setLicense(request.getParameter("license"));
		project.setStageOfDevelopment(request.getParameter("stageOfDevelopment"));

		ProjectDAO ppp = new ProjectDAO();
		ppp.createProject(project);

		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		map.put("project", project);
		return map;
	}
	
	/*private Map<String, Object> map = new HashMap<String, Object>();
	Project project = new Project();

	@Override
	public Map<String, Object> getParametersMap(HttpServletRequest request,
			HttpServletResponse response) {		
		project.setName(request.getParameter("name"));
		project.setUser(Integer.parseInt(request.getParameter("owner")));
		project.setDescription(request.getParameter("description"));*/
		/*DateFormat dateFormat = DateFormat.getDateInstance();
		Date date = null;
		try {
			date = dateFormat.parse(request.getParameter("datecr"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project.setDateOfCreation(date);
		try {
			date = dateFormat.parse(request.getParameter("datecl"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project.setDateOfClosing(date);*/
		/*ProjectCategory pc = new ProjectCategory();
		pc.setName(request.getParameter("category"));
		project.setCategory(pc);
		project.setVersion(Integer.parseInt(request.getParameter("version")));
		project.setLicense(request.getParameter("license"));
		project.setStageOfDevelopment(request.getParameter("stageOfDevelopment"));*/
		/*Technology tech = new Technology();
		tech.setName(request.getParameter("technology"));
		List<Technology> th = new ArrayList<Technology>();
		th.add(tech);
		project.setTechnology(th);
		ProgrammingLanguage progl = new ProgrammingLanguage();
		progl.setName(request.getParameter("languages"));
		List<ProgrammingLanguage> pl = new ArrayList<ProgrammingLanguage>();
		pl.add(progl);
		project.setLanguages(pl);*/

		/*ProjectDAO ppp = new ProjectDAO();
		ppp.createProject(project);

		// return "/addProjectOK.jsp";
		map.put("project", project);
		return map;
	}*/
}
