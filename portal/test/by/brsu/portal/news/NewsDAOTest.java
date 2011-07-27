package by.brsu.portal.news;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.brsu.portal.user.User;

public class NewsDAOTest {
	private Category category = new Category();
	private User author = new User();
	private NewsDAO nDAO = new NewsDAO();

	private News news = new News();

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
	public final void testCreateNews() {
		try {
			author.setId(1);
			category.setId(1);
			news = nDAO.createNews("testNews", "testMessage", category, author);
			if (news == null) {
				fail("return null");
			}
		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public final void testDelTable() {		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDelNews() {
		try {
			news = nDAO.createNews("testNews", "testMessage", category, author);
			Boolean b = nDAO.delNews(news);
			if (!b) {fail("Error save");}
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public final void testAddTable() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testUpdateNews() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testNewsDAO() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testReFreshConnection() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testReadNews() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testReadNewsByPage() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindNewsById() {
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
