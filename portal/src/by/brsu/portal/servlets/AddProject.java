/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.brsu.portal.project.Project;
import by.brsu.portal.project.ProjectList;

/**
 * @author Artur Smaliuk
 *
 */
public abstract class AddProject implements Action
{
	public String perform(HttpServletRequest request, HttpServletResponse response) 
	{
		Project newProject = createProject(request);
        
        HttpSession session = request.getSession();
        ProjectList projects = (ProjectList) session.getAttribute("projects");
        projects.setProject(newProject);
        session.setAttribute("projects", projects);
        
		// TODO Auto-generated method stub		
		return "/addProjectOK.jsp";
	}
	
	protected Project createProject(HttpServletRequest request) 
	{
        Project project = new Project();
        
        /*project.setName(request.getParameter("name"));
        project.setIdOwner(request.getParameter("owner"));
        project.setDescription(request.getParameter("description"));
        project.setCategory(request.getParameter("category"));
        project.setVersion(request.getParameter("version"));
        project.setLicense(request.getParameter("license"));
        project.setStageOfDevelopment(request.getParameter("stageOfDevelopment"));
        project.setTechnology(request.getParameter("technology"));
        project.setLanguages(request.getParameter("languages"));*/
        
        /* true, but error
         * 
         * project.setName(request.getParameter(RequestParameters.NAME));
        project.setIdOwner(request.getParameter(RequestParameters.OWNER));
        project.setDescription(request.getParameter(RequestParameters.DESCRIPTION));
        project.setCategory(request.getParameter(RequestParameters.CATEGORY));
        project.setVersion(request.getParameter(RequestParameters.VERSION));
        project.setLicense(request.getParameter(RequestParameters.LICENSE));
        project.setStageOfDevelopment(request.getParameter(RequestParameters.STAGEOFDEVELOPMENT));
        project.setTechnology(request.getParameter(RequestParameters.TECHNOLOGY));
        project.setLanguages(request.getParameter(RequestParameters.LANGUAGES));*/
		
        return project;
   }

	@Override
	public String nameReq() 
	{
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public Object send() 
	{
		// TODO Auto-generated method stub
		return "";
	}

}



/*public class AddProject implements Action
{
	@Override
	public String perform() 
	{
		// TODO Auto-generated method stub
		
		return "/addProjectOK.jsp";
	}

	@Override
	public String nameReq() 
	{
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public Object send() 
	{
		// TODO Auto-generated method stub
		return "";
	}
}*/
