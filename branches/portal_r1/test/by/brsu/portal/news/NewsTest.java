package by.brsu.portal.news;

import static org.junit.Assert.*;

import java.util.Date;

import by.brsu.portal.user.*;
import org.junit.*;

/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

/**
 * @author Aliaksei Ryzhkou
 * @version 20110722
 */
public class NewsTest {
	private static News news;
	Category category = new Category();
	User author = new User();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		news = new News();
		// news.setId(1);
		// User author = new User();
		// news.setAuthor(author);
		// Category category = new Category();
		// news.setCategory(category);
		// Date date = new Date();
		// news.setDate(date);
		// news.setImportant("");
		// news.setText("BlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBla");
		// news.setTitle("MyNews");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#toString()}.
	 */
	@Test
	public final void testToString() {
		String s = news.toString();
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#getId()}.
	 */
	@Test
	public final void testGetId() {
		long i = news.getId();
		// fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link by.brsu.portal.news.News#News(long, java.lang.String, java.lang.String, by.brsu.portal.news.Category, by.brsu.portal.user.User, java.lang.String)}
	 * .
	 */
	@Test
	public final void testNewsLongStringStringCategoryUserString() {
		//fail("blablabla"); // TODO
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#News()}.
	 */
	@Test
	public final void testNews() {
		try {
			news = new News();
			news = new News(1, "title", "text", category, author, "");
		} catch (Exception e) {
			fail("Not yet implemented:" + e);
		}
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#getTitle()}.
	 */
	@Test
	public final void testGetTitle() {
		try {
			String s = news.getText();
		} catch (Exception e) {
			fail("Not yet implemented:" + e);
		}
	}

	/**
	 * Test method for
	 * {@link by.brsu.portal.news.News#setTitle(java.lang.String)}.
	 */
	@Test
	public final void testSetTitle() {
		try {
			news.setTitle("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#getText()}.
	 */
	@Test
	public final void testGetText() {
		try {
			String s = news.getText();
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for
	 * {@link by.brsu.portal.news.News#setText(java.lang.String)}.
	 */
	@Test
	public final void testSetText() {
		try {
			news.setText("text");
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#getDate()}.
	 */
	@Test
	public final void testGetDate() {
		try {
			Date d = news.getDate();
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#setDate(java.util.Date)}.
	 */
	@Test
	public final void testSetDate() {
		try {
			news.setDate(new Date());
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#getCategory()}.
	 */
	@Test
	public final void testGetCategory() {
		try {
			Category c = news.getCategory();
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for
	 * {@link by.brsu.portal.news.News#setCategory(by.brsu.portal.news.Category)}
	 * .
	 */
	@Test
	public final void testSetCategory() {
		try {
			news.setCategory(new Category());
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#getImportant()}.
	 */
	@Test
	public final void testGetImportant() {
		try {
			String s = news.getImportant();
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for
	 * {@link by.brsu.portal.news.News#setImportant(java.lang.String)}.
	 */
	@Test
	public final void testSetImportant() {
		try {
			news.setImportant("important");
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#getAuthor()}.
	 */
	@Test
	public final void testGetAuthor() {
		try {
			User u = news.getAuthor();
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for
	 * {@link by.brsu.portal.news.News#setAuthor(by.brsu.portal.user.User)}.
	 */
	@Test
	public final void testSetAuthor() {
		try {
			news.setAuthor(new User());
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for {@link by.brsu.portal.news.News#setId(long)}.
	 */
	@Test
	public final void testSetId() {
		try {
			news.setId(1);
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for {@link java.lang.Object#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		try {
			int i = news.hashCode();
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEquals() {
		try {
			Boolean b1 = news.equals(news);
			News news2 = new News(1, "title123", "text12", category, author, "");
			Boolean b2 = news.equals(news2);
		} catch (Exception e) {
			fail("Not yet implemented:" + e); // TODO
		}
	}

}
