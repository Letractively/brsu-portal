package by.brsu.portal.user;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateUser() {
		try {
			UserDAO usr = new UserDAO();
			User user = new User();
			Status st = new Status();
			st.setIdStat(1);
			st.setName("name");
			user.setStatus(st);
			user.setName("name");
			user.setSurname("surname");
			user.setAbout("about");
			java.sql.Date dateOfBirth = new java.sql.Date(0);
			user.setDateOfBirth(dateOfBirth);
			user.setEmail("email");
			user.setIcq("123");
			user.setIdStat(1);
			user.setIQ(0);
			user.setNumberOfCautions(0);
			user.setPassword("123");
			user.setPicture(null);
			User user2 = usr.createUser(user);
			if (user2==null) fail("Error testCreateUser: null user");
		} catch (Exception e) {
			fail("Error testCreateUser:" + e.toString());
			System.out.println("Error testCreateUser:" + e.toString());
		}
	}

	@Test
	public final void testDeleteUser() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCreatUserTable() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindUserById() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindUserByName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetClass() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testEquals() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testClone() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testNotify() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testNotifyAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWaitLong() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWaitLongInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWait() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFinalize() {
		fail("Not yet implemented"); // TODO
	}

}
