/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.message;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import by.brsu.portal.user.UserDAO;


/**
 * @author Trutsik Eduard
 *
 */
public class testMessageDao {
	private MessageDao msgDao = new MessageDao();
	private Message msg = new Message();
	private UserDAO userDao = new UserDAO();
	private String emailFrom="ediktrutsik@gmail.com";
	
	@Test
	public void testCreateMessage() {		
			Date date = new Date(System.currentTimeMillis());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			try {
				msg.setDate(sqlDate);			
				msg.setUserTo(userDao.findUserById(2));			
				msg.setUserFrom(userDao.findUserById(3));
			} catch (IOException e) {
				e.printStackTrace();
			}
			msg.setPrevious(0);
			msg.setPriority(4);
			msg.setReaded(0);
			msg.setText("2TestText3");
			msg.setTitle("2TestTitle3");
			Assert.assertTrue(msgDao.creatMessages(msg));
	}
	
	@Test 
	public void testFindIdByEmail() {
		long expected=msgDao.findIdUserByEmail(emailFrom);
		long actual=5;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testFindAllMessageUsetTo() {
		List<Message> list = msgDao.findAllMessageUserTo(2);
		Assert.assertNotNull(list);
	}
	
	@Test
	public void testFindAllMessageUsetFrom() {
		List<Message> list = msgDao.findAllMessageUserFrom(2);
		Assert.assertNotNull(list);
	}
	
	@Test
	public void testFindMessageById() {
		//Message msg = msgDao.findMessageById(2);
		Assert.assertNotNull(msg);
	}
	
	@Test
	public void DelMessage() {
		Assert.assertTrue(msgDao.delMessage(6,2));
	}

}
