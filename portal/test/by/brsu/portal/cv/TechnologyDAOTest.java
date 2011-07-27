/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

import org.junit.Assert;
import org.junit.Test;

import by.brsu.portal.cv.TechnologyDAO;

/**
 * @author Roman Ulezlo
 * 
 */
public class TechnologyDAOTest {
	@Test
	public void testCreateTechnology() {
			TechnologyDAO td = new TechnologyDAO();
			Technology t1 = td.createTechnology(".NET");
			//System.out.println("test1 "+t1);
			Assert.assertTrue(t1!=null);
	}
	@Test
	public void testDeleteTechnology(){
			TechnologyDAO td = new TechnologyDAO();
			td.deleteTechnology(".NET");
			Technology t1 = td.findTechnologyByName(".NET");
			//System.out.println("test2 "+t1);		
			Assert.assertTrue(t1==null);
	}
}
