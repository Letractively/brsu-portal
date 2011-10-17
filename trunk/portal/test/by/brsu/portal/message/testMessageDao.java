/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.message;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;


/**
 * @author Trutsik Eduard
 *
 */
public class testMessageDao {
	private MessageDao msgDao = new MessageDao();
	private Message msg = new Message();
	private String email="TMOZ@inbox.ru";
	
	@Test
	public void testCreateMessage() {		
			Date date = new Date(System.currentTimeMillis());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			msg.setDate(sqlDate);
			msg.setIdToUser(msgDao.findIdByLogin(email));
			msg.setIdFromUser(msgDao.findIdByLogin(email));
			msg.setPrevious(0);
			msg.setPriority(0);
			msg.setReaded(0);
			msg.setText("TestText");
			msg.setTitle("TestTitle");
			System.out.println(msgDao.creatMessages(msg));
	}
	
	@Test 
	public void testFindIdByLogin() {
		System.out.println("id user = "+msgDao.findIdByLogin("TMOZ@inbox.ru"));
	}
	
	@Test
	public void testFindAllMessage() {
		List<Message> list = msgDao.findAllMessage();
		//System.out.println(list.toString());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
	}

}
