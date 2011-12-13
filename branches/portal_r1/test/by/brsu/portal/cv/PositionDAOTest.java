/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

import org.junit.Assert;
import org.junit.Test;

import by.brsu.portal.PortalTechnicalException;

/**
 * @author Roman Ulezlo
 * 
 */
public class PositionDAOTest {
	@Test
	public void testCreatePosition() throws PortalTechnicalException {
		PositionDAO td = new PositionDAO();
		Position t1 = td.createPosition("developerrr");
		//System.out.println("test1 "+t1);
		Assert.assertTrue(t1 != null);
	}

	@Test
	public void testDeletePosition() throws PortalTechnicalException {
		PositionDAO td = new PositionDAO();
		td.deletePosition("developerrr");
		Position t1 = td.findPositionByName("developerrr");
		//System.out.println("test2 "+t1);
		Assert.assertTrue(t1 == null);
	}
}
