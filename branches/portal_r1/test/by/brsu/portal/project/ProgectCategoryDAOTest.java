/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

import org.junit.Assert;
import org.junit.Test;

import by.brsu.portal.PortalTechnicalException;

/**
 * @author Roman Ulezlo
 * 
 */
public class ProgectCategoryDAOTest {
	@Test
	public void testCreateProjectCategory() throws PortalTechnicalException {
		ProjectCategoryDAO td = new ProjectCategoryDAO();
		ProjectCategory t1 = td.createProjectCategory("betta");
		//System.out.println("test1 "+t1);
		Assert.assertTrue(t1 != null);
	}

	@Test
	public void testDeleteProjectCategory() throws PortalTechnicalException {
		ProjectCategoryDAO td = new ProjectCategoryDAO();
		td.deleteProjectCategory("betta");
		ProjectCategory t1 = td.findProjectCategoryByName("betta");
		//System.out.println("test2 "+t1);
		Assert.assertTrue(t1 == null);
	}
}
