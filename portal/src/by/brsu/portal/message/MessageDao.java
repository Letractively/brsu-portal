package by.brsu.portal.message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.brsu.portal.ConnectionManager;
import by.brsu.portal.news.Category;
import by.brsu.portal.user.*;
/**
 * @author Trutsik
 */

public class MessageDao {
	Connection conn;
	
	/**
	 * Insert date in database news
	 */
	public Message creatMessages(String title, String text, User user, int previous, int readed, int priority) throws SQLException {
		Statement stat = null;
		ResultSet rs = null;
		try {
		Date date = new Date(System.currentTimeMillis());
		PreparedStatement set = conn
		.prepareStatement("INSERT INTO message VALUES(null,?,?,?,?,?,?,?)");
		set.setString(1, title);
		set.setString(2, text);
		set.setDate(3, date);
		set.setLong(4, user.getId());
		set.setLong(5, previous);
		set.setLong(6, readed);
		set.setLong(7, priority);
		set.executeUpdate();
		stat = conn.createStatement();
		rs = stat.executeQuery("SELECT id_message FROM message where title='"
				+ title + "' AND text='" + text + "' AND id_user_from="+user.getId());
		if (rs.next()) {
			Message msg = new Message();
			msg.setId(rs.getInt(1));
			msg.setTitle(title);
			msg.setText(text);
			msg.setDate(date);
			msg.setUser(user);
			msg.setPrevious(previous);
			msg.setReaded(readed);
			msg.setPriority(priority);
			return msg;
		}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return null;
	}
	
	/**
	 * Delete database message
	 */
	public Boolean delTable() throws SQLException {
		String query = "DROP TABLE message";
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public Boolean delMessage(Message msg) throws SQLException {
		String query = "DELETE FROM message WHERE id_message=?";
		Statement stat = null;
		try {
			PreparedStatement set = conn.prepareStatement(query);
			set.setLong(1, msg.getId());
			set.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
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
	 * Add table to database from message
	 */
	public void addTable() throws SQLException {
		String query = "create table message (id_message int not null auto_increment primary key,title varchar(100) not null,text varchar(3000) not null,data_m date not null,id_user_from int not null,id_previous_message int(11) default null,is_readed int(11) not null,priority int(11) not null,foreign key (id_user_from) references users(id_user),foreign key (priority) references priority(id_priority));";
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
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
	 */
	public Message updateMessage(long id, String title, String text,
			Date date, User user, int previous, int readed, int priority) throws SQLException {

		Statement stat = null;
		ResultSet rs = null;
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
				e.printStackTrace();
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return null;
	}
	/**
	 * @param conn
	 */
	public MessageDao() {
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Refresh this connection from datebase
	 */
	public void ReFreshConnection() {
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Get List News from datebase
	 */
	public List<Message> readMessage() {
		Statement stat = null;
		ResultSet rs = null;
		List<Message> msg = new ArrayList<Message>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT * FROM message");
			while (rs.next()) {
				Message m = new Message();
				Category category = new Category();
				category.setId(1);
				User user = new User();
				user.setId(1);
				user.setName("root");
				m.setId(rs.getLong(1));
				m.setTitle(rs.getString(2));
				m.setText(rs.getString(3));
				m.setDate(rs.getDate(4));
				m.setUser(user);
//				m.setPrevious(previous);
//				m.setReaded(readed);
//				m.setPriority(priority);
				msg.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionManager.getConnectorPool().releaseConnection(conn);
		return msg;
	}
	/**
	 * Get List News from datebase for a given page
	 */
	public List<Message> readMessageByPage(int page, int i) {
		//Statement stat = null;
		//ResultSet rs = null;
		List<Message> msg = new ArrayList<Message>();
		ConnectionManager.getConnectorPool().releaseConnection(conn);
		return msg;
	}
	public Message findMessageById() {
		Message msg = new Message();
		ConnectionManager.getConnectorPool().releaseConnection(conn);
		return msg;
	}
}
