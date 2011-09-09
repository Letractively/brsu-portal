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
	private Map<String, Object> mp = new HashMap<String, Object>();
	Project project = new Project();

	@Override
	public String perform(HttpServletRequest request,HttpServletResponse response) 
	{
		ProjectCategory pc = new ProjectCategory();
		project.setName(request.getParameter("name"));
		project.setDescription(request.getParameter("description"));
		pc.setName(request.getParameter("category"));
		project.setCategory(pc);
		project.setLicense(request.getParameter("license"));
		project.setStageOfDevelopment(request.getParameter("stageOfDevelopment"));
		Technology tech = new Technology();
		tech.setName(request.getParameter("technology"));
		List<Technology> th = new ArrayList<Technology> ();
		th.add(tech);
		project.setTechnology(th);
		ProgrammingLanguage progl = new ProgrammingLanguage();
		progl.setName(request.getParameter("languages"));
		List<ProgrammingLanguage> pl = new ArrayList<ProgrammingLanguage> ();
		pl.add(progl);
		project.setLanguages(pl);
		
		ProjectDAO ppp = new ProjectDAO();
		ppp.createProject(project);
		
		//return "/addProjectOK.jsp";
		return "/addProjectTemplate.jsp";
	}

	// protected Project createProject(HttpServletRequest request) {

	// Project project = new Project();

	/*
	 * project.setName(request.getParameter("name"));
	 * project.setIdOwner(request.getParameter("owner"));
	 * project.setDescription(request.getParameter("description"));
	 * project.setCategory(request.getParameter("category"));
	 * project.setVersion(request.getParameter("version"));
	 * project.setLicense(request.getParameter("license"));
	 * project.setStageOfDevelopment
	 * (request.getParameter("stageOfDevelopment"));
	 * project.setTechnology(request.getParameter("technology"));
	 * project.setLanguages(request.getParameter("languages"));
	 */

	/*
	 * true, but error
	 * 
	 * project.setName(request.getParameter(RequestParameters.NAME));
	 * project.setIdOwner(request.getParameter(RequestParameters.OWNER));
	 * project
	 * .setDescription(request.getParameter(RequestParameters.DESCRIPTION));
	 * project .setCategory(request.getParameter(RequestParameters.CATEGORY));
	 * project.setVersion(request.getParameter(RequestParameters.VERSION));
	 * project.setLicense(request.getParameter(RequestParameters.LICENSE));
	 * project.setStageOfDevelopment(request.getParameter(RequestParameters.
	 * STAGEOFDEVELOPMENT));
	 * project.setTechnology(request.getParameter(RequestParameters
	 * .TECHNOLOGY));
	 * project.setLanguages(request.getParameter(RequestParameters .LANGUAGES));
	 */

	// /return project;
	// }

	@Override
	public Map<String, Object> getParametersMap(HttpServletRequest request,
			HttpServletResponse response) {
		mp.put("project", project);
		return mp;
	}

}

/*
 * public class AddProject implements Action {
 * 
 * @Override public String perform() { // TODO Auto-generated method stub
 * 
 * return "/addProjectOK.jsp"; }
 * 
 * @Override public String nameReq() { // TODO Auto-generated method stub return
 * ""; }
 * 
 * @Override public Object send() { // TODO Auto-generated method stub return
 * ""; } }
 */
