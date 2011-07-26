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
public class TechnologyTest {
	@Test
	public void testCreateTechnology() {
		try {
			TechnologyDAO td = new TechnologyDAO();
			Technology t = new Technology();
			t = td.createTechnology("developer");
			System.out.println(t);
		} catch (Exception ex) {
			Assert.fail();
		}
	}
	@Test
	public void testDeleteTechnology(){
		try {
			TechnologyDAO td = new TechnologyDAO();
			td.createTechnology("developer1");
			td.deleteTechnology("developer1");			
		} catch (Exception ex) {
			Assert.fail();
		}
	}
}
