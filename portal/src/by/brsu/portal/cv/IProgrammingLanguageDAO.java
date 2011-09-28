/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

import java.util.List;

import by.brsu.portal.PortalTechnicalException;

/**
 * @author Artur Smaliuk
 *
 */
public interface IProgrammingLanguageDAO 
{
	/**
	 * Finds all programmlanguages
	 * 
	 * @return list of programminglanguages
	 * @throws PortalTechnicalException
	 */
	public List<ProgrammingLanguage> findAllLanguages()
			throws PortalTechnicalException;
}
