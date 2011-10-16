package by.brsu.portal.message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.brsu.portal.ConnectionManager;
import by.brsu.portal.news.Category;
import by.brsu.portal.project.Project;
import by.brsu.portal.user.*;
/**
 * @author Trutsik Eduard
 */

public class MessageDao {
	private Connection conn;
	
	/**
	 * Insert date in database news
	 */
	public Message creatMessages(String title, String text, long idFromUser, int previous, int readed, int priority) throws SQLException {
		Statement stat = null;
		ResultSet rs = null;
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
	
	public long findIdByLogin(String email) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "Select id_user from users where email='"+email+"'";
		ResultSet rs = null;
		PreparedStatement st = null;
		
		try {
			long id=Long.valueOf(query).longValue();
			return id;
		} catch (NumberFormatException e) {
			e.printStackTrace();
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
