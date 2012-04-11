/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.message;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


/**
 * @author Trutsik Eduard
 *
 */
public class testMessageDao {
	private MessageDao msgDao = new MessageDao();
	private Message msg = new Message();
	private String emailFrom="ediktrutsik@gmail.com";
	
	@Test
	public void testCreateMessage() {		
			Date date = new Date(System.currentTimeMillis());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			msg.setDate(sqlDate);
			msg.setIdUserTo(2);
			msg.setIdUserFrom(3);
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
		Message msg = msgDao.findMessageById(2);
		Assert.assertNotNull(msg);
	}
	
	@Test
	public void DelMessage() {
		Assert.assertTrue(msgDao.delMessage(6,2));
	}

}
