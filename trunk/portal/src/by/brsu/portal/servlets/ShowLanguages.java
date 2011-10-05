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

/**
 * @author Artur Smaliuk
 *
 */
public class ShowLanguages implements Action
{
	private ProgrammingLanguageDAO pDAO = new ProgrammingLanguageDAO();
	private Map<String, Object> ma_pl = new HashMap<String, Object>();

	@Override
	public boolean perform(HttpServletRequest request,
			HttpServletResponse response) {
		List<ProgrammingLanguage> listprlanguage  = pDAO.findAllLanguages();
		ma_pl.put("languages", listprlanguage);
		return true;
	}

	@Override
	public Map<String, Object> getParametersMap() {
		return ma_pl;
	}

}
