/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.brsu.portal.cv.ProgrammingLanguageDAO;
import by.brsu.portal.cv.ProgrammingLanguage;
import by.brsu.portal.cv.TechnologyDAO;
import by.brsu.portal.user.UserDAO;

/**
 * @author Artur Smaliuk
 *
 */
public class ShowLanguages implements Action
{
	private ProgrammingLanguageDAO plDAO = new ProgrammingLanguageDAO();
	private TechnologyDAO tDAO = new TechnologyDAO();
	private UserDAO uDAO = new UserDAO();
	private Map<String, Object> ma_pl = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		//List<ProgrammingLanguage> listprlanguage  = plDAO.findAllLanguages();
		//ma_pl.put("languages", listprlanguage);
		ma_pl.put("languages", plDAO.findAllLanguages());
		ma_pl.put("technology", tDAO.findAllTechologies());
		ma_pl.put("owner", uDAO.FindAllUser());		
		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		return ma_pl;
	}

}
