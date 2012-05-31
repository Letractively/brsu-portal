package by.brsu.portal.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.brsu.portal.project.ProjectDAO;

public class AddParticipantsInProject implements Action{
	private Map<String, Object> map = new HashMap<String, Object>();
	private ProjectDAO projectDAO = new ProjectDAO();
	
	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String [] participants = request.getParameterValues("list1");
		if (null!=participants){
			for (int i = 0; i < participants.length; i++){
				projectDAO.addParticipantInProject(Long.parseLong(request.getParameter("project")),Long.parseLong(participants[i].split(",")[0]), Long.parseLong(participants[i].split(",")[1]));
				System.out.println(participants[i]);
			}
		}
		System.out.println(request.getParameter("project"));
		map.put("", "");
		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		return map;
	}

}
