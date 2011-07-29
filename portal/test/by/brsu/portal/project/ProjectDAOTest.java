/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import by.brsu.portal.cv.ProgrammingLanguage;
import by.brsu.portal.cv.Technology;


/**
 * @author Artur Smaliuk
 *
 */
public class ProjectDAOTest 
{
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateProject() 
	{
		ProjectDAO pr = new ProjectDAO();
		ProjectCategory cat = new ProjectCategory();
		cat.setName("category");
		List<Technology> techn = new ArrayList<Technology>();
		Technology temptechn = new Technology();
		temptechn.setId(5);
		temptechn.setName(".Net");
		techn.add(temptechn);
		List<ProgrammingLanguage> lang = new ArrayList<ProgrammingLanguage>();
		ProgrammingLanguage templang = new ProgrammingLanguage(2, "russ");
		lang.add(templang);
		Date op = new Date();
		Date cl = new Date();
		op.setDate(12);
		op.setMonth(3);
		op.setYear(2010);
		cl.setDate(5);
		cl.setMonth(8);
		cl.setYear(2011);
		Project test = pr.createProject(2, "TestProject", "description", op, cl, 
				cat, 5, "license", "stageOfDevelopment", techn, lang);
		Assert.assertTrue(test != null);
	}

	@Test
	public void testDeleteProject() 
	{
		ProjectDAO pr = new ProjectDAO();
		pr.deleteProject("TestProject");
		Project test = pr.findProjectByName("TestProject");
		Assert.assertTrue(test == null);
	}

}
