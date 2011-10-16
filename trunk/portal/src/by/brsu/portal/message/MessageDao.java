package by.brsu.portal.message;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import by.brsu.portal.ConnectionManager;
import by.brsu.portal.news.Category;
import by.brsu.portal.project.Project;
import by.brsu.portal.user.*;
/**
 * @author Trutsik Eduard
 */

public class MessageDao {
	private Connection conn;
	private static final Logger log = Logger.getLogger(MessageDao.class);
	/**
	 * Insert date in database news
	 * @throws IOException 
	 */
<<<<<<< .mine
	public Message creatMessages(String title, String text, long idFromUser, int previous, int readed, int priority) throws SQLException {
=======
	public Message creatMessages(String title, String text, User user, int previous, int readed, int priority) throws SQLException, IOException {
>>>>>>> .r329
		Statement stat = null;
		ResultSet rs = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU-Log.txt", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
		Date date = new Date(System.currentTimeMillis());
		PreparedStatement set = conn
		.prepareStatement("INSERT INTO message VALUES(null,?,?,?,?,?,?,?)");
		set.setString(1, title);
		set.setString(2, text);
		set.setDate(3, date);
		set.setLong(4, idFromUser);
		set.setLong(5, previous);
		set.setLong(6, readed);
		set.setLong(7, priority);
		set.executeUpdate();
		stat = conn.createStatement();
		Message msg = new Message(title, text, date, idFromUser, previous, readed, priority);
		return msg;
//		rs = stat.executeQuery("SELECT id_message FROM message where title='"
//				+ title + "' AND text='" + text + "' AND id_user_from="+idFromUser);
//		if (rs.next()) {
//			Message msg = new Message();
//			msg.setId(rs.getInt(1));
//			msg.setTitle(title);
//			msg.setText(text);
//			msg.setDate(date);
//			msg.setIdFromUser(idFromUser);
//			msg.setPrevious(previous);
//			msg.setReaded(readed);
//			msg.setPriority(priority);
//			return msg;
//		}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				log.error(e);
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return null;
	}
	
<<<<<<< .mine
=======
	/**
	 * Delete database message
	 * @throws IOException 
	 */
	public Boolean delTable() throws SQLException, IOException {
		String query = "DROP TABLE message";
		Statement stat = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU-Log.txt", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			log.error(e);
			return false;
		} finally {
			try {
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
	}
	
>>>>>>> .r329
	public Boolean delMessage(Message msg) throws SQLException, IOException {
		String query = "DELETE FROM message WHERE id_message=?";
		Statement stat = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU-Log.txt", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			PreparedStatement set = conn.prepareStatement(query);
			set.setLong(1, msg.getId());
			set.executeUpdate();
			return true;
		} catch (SQLException e) {
			log.error(e);
			return false;
		} finally {
			try {
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				return false;
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
	}	
	/**
<<<<<<< .mine
=======
	 * Add table to database from message
	 * @throws IOException 
	 */
	public void addTable() throws SQLException, IOException {
		String query = "create table message (id_message int not null auto_increment primary key,title varchar(100) not null,text varchar(3000) not null,data_m date not null,id_user_from int not null,id_previous_message int(11) default null,is_readed int(11) not null,priority int(11) not null,foreign key (id_user_from) references users(id_user),foreign key (priority) references priority(id_priority));";
		Statement stat = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU-Log.txt", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			log.error(e);
		} finally {
			try {
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
	}
	
	/**
	 * Update table to database from news
	 * @throws IOException 
	 */
	public Message updateMessage(long id, String title, String text,
			Date date, User user, int previous, int readed, int priority) throws SQLException, IOException {
		Statement stat = null;
		ResultSet rs = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU-Log.txt", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			//Date date = new Date(System.currentTimeMillis());
			PreparedStatement set = conn
					.prepareStatement("UPDATE news SET title=?,text=?,data_m=?,id_user_from=? WHERE id_previous_message=? WHERE is_readed=? WHERE priority=?");
			set.setString(1, title);
			set.setString(2, text);
			set.setDate(3, date);
			set.setLong(4, user.getId());
			set.setLong(5, previous);
			set.setLong(6, readed);
			set.setLong(7, priority);
			set.executeUpdate();
			Message msg = new Message(id, title, text, date, user, previous, readed, priority);
			return msg;
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				log.error(e);
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return null;
	}
	/**
>>>>>>> .r329
	 * @param conn
	 * @throws IOException 
	 */
	public MessageDao() throws IOException {
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU-Log.txt", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
		} catch (Exception e) {
			log.error(e);
		}
	}
	/**
	 * Refresh this connection from datebase
	 * @throws IOException 
	 */
	public void ReFreshConnection() throws IOException {
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU-Log.txt", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
		} catch (Exception e) {
			log.error(e);
		}
	}
<<<<<<< .mine
	
	public long findIdByLogin(String email) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "Select id_user from users where email='"+email+"'";
=======
	/**
	 * Get List News from datebase
	 * @throws IOException 
	 */
	public List<Message> readMessage() throws IOException {
		Statement stat = null;
>>>>>>> .r329
		ResultSet rs = null;
<<<<<<< .mine
		PreparedStatement st = null;
		
=======
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU-Log.txt", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		List<Message> msg = new ArrayList<Message>();
>>>>>>> .r329
		try {
			long id=Long.valueOf(query).longValue();
			return id;
//			st.setString(1, email);
//			rs = st.executeQuery(query);
//			if (rs.next()) {
//				return true;
//			}
		} catch (NumberFormatException e) {
			log.error(e);
		} finally {
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return 0;
		
	}
	public List<Message> findAllMessage() {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Message";
		ResultSet rs = null;
		PreparedStatement st = null;
		try 
		{
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			List<Message> msg = new ArrayList<Message>();
			while (rs.next()) 
			{
				Message tempmsg = new Message();
				tempmsg.setId(rs.getLong(1));
				tempmsg.setTitle(rs.getString(2));
				tempmsg.setText(rs.getString(3));				
				tempmsg.setDate(rs.getDate(4));
				tempmsg.setIdFromUser(rs.getLong(5));
				tempmsg.setPrevious(rs.getInt(6));
				tempmsg.setReaded(rs.getInt(7));
				tempmsg.setPriority(rs.getInt(8));
				msg.add(tempmsg);
			}
			return msg;
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
}
