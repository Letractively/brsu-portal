/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.List;
import by.brsu.portal.project.Project;
import by.brsu.portal.project.ProjectDAO;

/**
 * @author Roman Ulezlo
 *
 */
public class ShowProjects implements Action{
	ProjectDAO pDAO = new ProjectDAO();
	List<Project> projects = pDAO.findAllProjects();

	public String nameReq() {
		return "projects";
	}

	public Object send() {
		return projects;
	}

	public String perform() {
		return "/project1.jsp";
	}
}
