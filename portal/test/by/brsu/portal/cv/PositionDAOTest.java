/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Roman Ulezlo
 * 
 */
public class PositionDAOTest {
	@Test
	public void testCreatePosition() {
		PositionDAO td = new PositionDAO();
		Position t1 = td.createPosition("developer");
		//System.out.println("test1 "+t1);
		Assert.assertTrue(t1 != null);
	}

	@Test
	public void testDeletePosition() {
		PositionDAO td = new PositionDAO();
		td.deletePosition("developer");
		Position t1 = td.findPositionByName("developer");
		//System.out.println("test2 "+t1);
		Assert.assertTrue(t1 == null);
	}
}
