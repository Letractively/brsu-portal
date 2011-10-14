/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

package by.brsu.portal.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import by.brsu.portal.ConnectionManager;

/**
 * @author Hraznykh_Pavel
 * @version 20110827
 */
public class UserDAO {
	public User createUser(User user) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "insert into users values (null,?,?,?,?,?,?,?,?,?,null,?,?,?,?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, user.getName());
			st.setString(2, user.getSurname());
			st.setString(3, user.getEmail());
			st.setDate(4, (Date) user.getDateOfBirth());
			st.setString(5, user.getTelephone());
			st.setString(6, user.getPassword());
			st.setInt(7, user.getSex());
			st.setString(8, user.getSkype());
			st.setString(9, user.getIcq());
			st.setLong(10, user.getStatus().getIdStat());
			st.setBlob(11, user.getPicture());
			Date date = new Date(System.currentTimeMillis()); //date.setTime(System.currentTimeMillis());
			st.setDate(12, (Date) date);
			st.setInt(13, user.getNumberOfCautions());
			st.setInt(14, 1);
			st.executeUpdate();
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO log error
		} finally {
			try {
				
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public User deleteUser(long id) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "delete from users where id_user=?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(query);
			st.setLong(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException e) {
			}
		}
		return null;

	}

	public void creatUserTable() {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "create table users(id int not null auto_increment PRIMARY key, name char(30), NOT NULL, surname VARCHAR( 100 ) NOT NULL ,emai VARCHAR( 100 ) NOT NULL ,dateOfBirth DATE NULL ,telephone VARCHAR( 100 ) NULL ,password VARCHAR( 100 ) NOT NULL ,about TEXT NULL , sex VARCHAR( 100 ) NULL ,skype VARCHAR( 100 ) NULL ,isq VARCHAR( 100 ) NULL ,IQ INT( 2 ) NULL, idStat INT( 10 ) NOT NULL ,picture BLOB NULL ,dateOfLastVisit DATE NULL ,numberOfCautions VARCHAR( 100 ) NULL)"; 

		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO wrong syntax
		} finally {
			try {
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException e) {
			}
		}

	}

	public User findUserById(long id) {
		
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "Select * from users where id_user=?";
		
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(query);
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				User user = new User();
					user.setId(rs.getLong(1));
				    user.setSurname(rs.getString(2));
				    user.setName(rs.getString(3));   
				    user.setEmail(rs.getString(4));
				    user.setDateOfBirth(rs.getDate(5));	    
				    user.setTelephone(rs.getString(6)); 
				    user.setSex(rs.getInt(8));
				    user.setSkype(rs.getString(9));
				    user.setDateOfLastVisit(rs.getDate(14));
				return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}

		}
		return null;
	}

	public User findUserByName(String name) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "Select * from user where name=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getLong(1));
				user.setName(rs.getString(2));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return null;
	}



	public List<User> FindAllUser() {
		  Connection conn = ConnectionManager.getConnectorPool().getConnection();
		  ResultSet rs = null;
		  PreparedStatement st = null;
		  List<User> us = new ArrayList<User>();
	  try{
		  		st = conn.prepareStatement("");  
		  		
		  		rs = st.executeQuery("Select * from users");
			  		  
		   while (rs.next()) 
		   {
		    User users = new User();
		    users.setId(rs.getLong(1));
		    users.setSurname(rs.getString(2));
		    users.setName(rs.getString(3));   
		    users.setEmail(rs.getString(4));
		    users.setDateOfBirth(rs.getDate(5));	    
		    users.setTelephone(rs.getString(6)); 
		    users.setSex(rs.getInt(8));
		    users.setSkype(rs.getString(9));
		    users.setDateOfLastVisit(rs.getDate(14));
		    us.add(users);   
		   } 	  
		  return us;
		  }		 
		catch (SQLException e) 
		  {
			System.out.println(e);
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
			   System.out.println(ex);
		   }
		  }
		  return null;

	}


	@SuppressWarnings("null")
	public boolean findUserByEmail(String email) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "Select * from user where email=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st.setString(1, email);
			rs = st.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.getConnectorPool().releaseConnection(conn);
		}
		return false;
	}

		public User updateUser(long id) {
			Connection conn = ConnectionManager.getConnectorPool().getConnection();
			String query = "update users set surname=? where id_user=?";
			ResultSet rs = null;
			PreparedStatement st = null;
			
			try {
				st = conn.prepareStatement(query);
			
					st.setString(1, "gfghjhjljhlk");
				st.setLong(2, id);
				st.executeUpdate();
			
				//if (rs.next()) {
					//User user = new User();
					//user.setId(rs.getLong(1));
					//user.setSurname(rs.getString(2));
					return null;
				//}
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO log error
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (st != null)
						st.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return null;
		}

	
	
	}


