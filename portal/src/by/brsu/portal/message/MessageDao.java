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
		PreparedStatement stat = null;
		Date date = new Date(System.currentTimeMillis());
		try {		
		stat = conn.prepareStatement("INSERT INTO message VALUES(null,?,?,?,?,?,null,?,?)");
		stat.setString(1, msg.getTitle());
		stat.setString(2, msg.getText());
		stat.setDate(3, date);
		stat.setLong(4, msg.getIdUserTo());
		stat.setLong(5, msg.getIdUserFrom());
		stat.setLong(6, msg.getReaded());
		stat.setLong(7, msg.getPriority());
		stat.executeUpdate();
		return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return false;
	}	
	
	public boolean delMessage(long idMessage) {
		String query = "DELETE FROM message WHERE id_message=?";
		PreparedStatement stat=null;
		if(idMessage==0){
			return false;
		}
		try {
			stat = conn.prepareStatement(query);
			stat.setLong(1, idMessage);
			stat.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return false;
	}	
	
	public long findIdUserByEmail(String email) {
		PreparedStatement stat=null;
		ResultSet rs = null;
		String query = "Select id_user from users where email=?";		
		if(email=="") {
			return 0;
		}
		try {
			stat = conn.prepareStatement(query);
			stat.setString(1, email);
			rs = stat.executeQuery();
			if(rs.next()) {
				long id=rs.getLong(1);
				return id;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return 0;		
	}
	
	public Message findMessageById(long idMessage) {
		ResultSet rs = null;
		PreparedStatement stat=null;
		String query = "Select * from Message where Message.id_message=?";
		try 
		{
			stat = conn.prepareStatement(query);
			stat.setLong(1, idMessage);
			rs = stat.executeQuery();			
			if (rs.next()) 
			{
				Message msg = new Message();
				msg.setId(rs.getLong(1));
				msg.setTitle(rs.getString(2));
				msg.setText(rs.getString(3));				
				msg.setDate(rs.getDate(4));				
				msg.setIdUserTo(rs.getLong(5));
				msg.setIdUserFrom(rs.getLong(6));
				msg.setPrevious(rs.getInt(7));
				msg.setReaded(rs.getInt(8));
				msg.setPriority(rs.getInt(9));
				return msg;
			} 
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				if (stat != null) {
					stat.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return null;
	}
	
	public List<Message> findAllMessageUserTo(long idUserTo) {
		ResultSet rs = null;
		PreparedStatement stat=null;
		String query = "Select * from Message where Message.id_user_to=?";
		List<Message> msg = new ArrayList<Message>();		
		try 
		{
			stat = conn.prepareStatement(query);
			stat.setLong(1, idUserTo);
			rs = stat.executeQuery();			
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
			e.printStackTrace();
		}
		finally 
		{
			try {
				if (stat != null) {
					stat.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return null;
	}
	
	public List<Message> findAllMessageUserFrom(long idUserFrom) {
		PreparedStatement stat = null;
		ResultSet rs = null;		
		String query = "Select * from Message where Message.id_user_from=?";	
		List<Message> msg = new ArrayList<Message>();
		try 
		{
			stat = conn.prepareStatement(query);
			stat.setLong(1, idUserFrom);
			rs = stat.executeQuery();			
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
			e.printStackTrace();
		}
		finally 
		{
			try {
				if (stat != null) {
					stat.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return null;
	}
}
