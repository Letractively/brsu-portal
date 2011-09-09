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
		project.setName(request.getParameter("name"));
		project.setDescription(request.getParameter("description"));
		//project.setCategoryForOne(request.getParameter("category"));
		project.setLicense(request.getParameter("license"));
		project.setStageOfDevelopment(request.getParameter("stageOfDevelopment"));
		//project.setTechnologyForOne(request.getParameter("technology"));
		//project.setLanguagesForOne(request.getParameter("languages"));
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
