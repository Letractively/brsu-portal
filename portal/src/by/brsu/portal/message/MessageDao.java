package by.brsu.portal.message;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.brsu.portal.ConnectionManager;
import by.brsu.portal.user.UserDAO;

/**
 * @author Trutsik Eduard
 * 
 */

public class MessageDao {
	private Connection conn;
	private UserDAO userDao;
	
	/**
	 * @param conn
	 */
	public MessageDao() {
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
			userDao = new UserDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean creatMessages(Message msg) {
		PreparedStatement stat = null;
		Statement st = null;
		ResultSet rs = null;
		long res = 0;
		Date date = new Date(System.currentTimeMillis());
		try {
			stat = conn.prepareStatement("INSERT INTO message VALUES(null,?,?,?,?,null,?,?)");
			stat.setString(1, msg.getTitle());
			stat.setString(2, msg.getText());
			stat.setDate(3, date);
			stat.setLong(4, msg.getUserFrom().getId());
			stat.setLong(5, msg.getReaded());
			stat.setLong(6, msg.getPriority());
			if (stat.executeUpdate() != 0) {
				st = conn.createStatement();
				rs = st.executeQuery("SELECT LAST_INSERT_ID()");
				if (rs.next()) {
					res = rs.getLong(1);
					if (res != 0) {
						stat = conn.prepareStatement("INSERT INTO l_user_to VALUES(?,?)");
						stat.setLong(1, res);
						stat.setLong(2, msg.getUserTo().getId());
						if (stat.executeUpdate() != 0) {
							return true;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return false;
	}	
	
	public boolean updateMessages(Message msg) {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement("UPDATE message SET message.is_readed=1 WHERE message.id_message=?");
			stat.setLong(1, msg.getId());
			if (stat.executeUpdate() != 0) {
				return true;
			}
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
	
	public boolean delMessage(long idMessage,long idUser) {
		String query = "DELETE FROM l_user_to WHERE id_message=? and id_user=?";
//		String query2 = "DELETE FROM message WHERE id_message=?";
		PreparedStatement stat=null;		
//		PreparedStatement stat2=null;		
		try {
			if (idMessage != 0 && idUser != 0) {
				stat = conn.prepareStatement(query);
				stat.setLong(1, idMessage);
				stat.setLong(2, idUser);
//				stat2 = conn.prepareStatement(query2);
//				stat2.setLong(1, idMessage);
				if (stat.executeUpdate() != 0) {
//					if(stat2.executeUpdate() != 0) {
//						return true;
//					}					
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
//				if (stat2 != null) {
//					stat2.close();
//				}
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
				return rs.getLong(1);
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
		try 
		{
			stat = conn.prepareStatement("Select l_user_to.id_user, message.* from message,l_user_to where message.id_message=? and l_user_to.id_message=message.id_message");
			stat.setLong(1, idMessage);
			rs = stat.executeQuery();
			if (rs.next()) 
			{
				return new Message(idMessage,rs.getString(3),rs.getString(4),rs.getDate(5),userDao.findUserById(rs.getLong(1)),userDao.findUserById(rs.getLong(6)),rs.getInt(7),rs.getInt(8),rs.getInt(9));
			} 
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try {
				if (stat != null) 
				{
					stat.close();
				}
				if(rs!=null) 
				{
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return null;
	}
	
	public List<Long> findAllPriority() {
		ResultSet rs = null;
		PreparedStatement stat=null;
		String query = "SELECT * FROM priority";
		List<Long> priority = new ArrayList<Long>();
		try 
		{
			stat = conn.prepareStatement(query);
			rs = stat.executeQuery();
			while (rs.next()) 
			{
				priority.add(rs.getLong(1));				
			}
			return priority;
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
		String query = "Select id_message from l_user_to where l_user_to.id_user=?";
		List<Message> msg = new ArrayList<Message>();
		Message tempMessage=new Message();
		try 
		{
			stat = conn.prepareStatement(query);
			stat.setLong(1, idUserTo);
			rs = stat.executeQuery();			
			while (rs.next()) 
			{
					tempMessage= this.findMessageById(rs.getLong(1));
					tempMessage.setUserTo(userDao.findUserById(idUserTo));
					msg.add(tempMessage);											
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
		String query = "Select l_user_to.id_user,message.* from message,l_user_to where message.id_user_from=? and l_user_to.id_message=message.id_message";	
		//String query = "Select * from message where message.id_user_from=?";	
		List<Message> msg = new ArrayList<Message>();
		try 
		{
			stat = conn.prepareStatement(query);
			stat.setLong(1, idUserFrom);
			rs = stat.executeQuery();			
			while (rs.next()) 
			{	
				msg.add(new Message(rs.getLong(2),rs.getString(3),rs.getString(4),rs.getDate(5),userDao.findUserById(rs.getLong(1)),userDao.findUserById(rs.getLong(6)),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
				//msg.add(new Message(rs.getLong(2),rs.getString(3),rs.getString(4),rs.getDate(5),userDao.findUserById(rs.getLong(6)),userDao.findUserById(rs.getLong(6)),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
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
