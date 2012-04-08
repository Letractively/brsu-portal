package by.brsu.portal.message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.brsu.portal.ConnectionManager;
/**
 * @author Trutsik Eduard
 */

public class MessageDao {
	private Connection conn;
	
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
	
	public boolean creatMessages(Message msg){
		Statement stat = null;
		ResultSet rs = null;
		Date date = new Date(System.currentTimeMillis());
		//System.out.println("send "+msg.toString());
		try {		
		PreparedStatement set = conn.prepareStatement("INSERT INTO message VALUES(null,?,?,?,?,?,null,?,?)");
		set.setString(1, msg.getTitle());
		set.setString(2, msg.getText());
		set.setDate(3, date);
		set.setLong(4, msg.getIdUserTo());
		set.setLong(5, msg.getIdUserFrom());
		set.setLong(6, msg.getReaded());
		set.setLong(7, msg.getPriority());
		set.executeUpdate();
		stat = conn.createStatement();	
		return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return false;
	}	
	
	public boolean delMessage(long idMessage) {
		String query = "DELETE FROM message WHERE id_message=?";
		Statement stat = null;
		if(idMessage==0){
			return false;
		}
		try {
			PreparedStatement set = conn.prepareStatement(query);
			set.setLong(1, idMessage);
			set.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stat != null)
					stat.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException e) {
				return false;
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
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
	
	public long findIdUserByEmail(String email) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select id_user from users where email='"+email+"'";	
		ResultSet rs = null;
		PreparedStatement st = null;		
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			if(rs.next()) {
				long id=rs.getLong(1);
				return id;
			}			
		} catch (SQLException e) {
			} finally {
				try {
					if (st != null)
						st.close();
					if (rs!=null)
						rs.close();
				} catch (SQLException e) {
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return 0;		
	}
	
	public List<Message> findAllMessageUserTo(long idUserTo) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Message where Message.id_user_to="+idUserTo;
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
				tempmsg.setIdUserTo(rs.getLong(5));
				tempmsg.setIdUserFrom(rs.getLong(6));
				tempmsg.setPrevious(rs.getInt(7));
				tempmsg.setReaded(rs.getInt(8));
				tempmsg.setPriority(rs.getInt(9));
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
	
	public List<Message> findAllMessageUserFrom(long idUserFrom) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Message where Message.id_user_from="+idUserFrom;
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
				tempmsg.setIdUserTo(rs.getLong(5));
				tempmsg.setIdUserFrom(rs.getLong(6));
				tempmsg.setPrevious(rs.getInt(7));
				tempmsg.setReaded(rs.getInt(8));
				tempmsg.setPriority(rs.getInt(9));
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
