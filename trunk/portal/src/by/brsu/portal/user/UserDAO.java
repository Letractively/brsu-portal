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

import by.brsu.portal.ConnectionManager;


/**
 * @author Hraznykh_Pavel
 * @version 20110827
 */
public class UserDAO {
	/**
	 * @param user
	 * @return user(+id)
	 * @author Aliaksei Ryzhkou
	 */
	public User createUser(User user) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();;
		String query = "insert into users values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			st.setInt(10, user.getIQ());	
			st.setLong(11, user.getStatus().getIdStat());
			st.setBlob(12, user.getPicture());
			Date tmpDt = new Date(1);
			st.setDate(13, tmpDt);
			st.setInt(14, user.getNumberOfCautions());
			st.setInt(15, 1);
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	public void deleteUser(User user) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "delete from user where id=?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(query);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
			}
		}

	}

	public void creatUserTable() {
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String query = "create table users(id int not null auto_increment PRIMARY key, name char(30), NOT NULL, surname VARCHAR( 100 ) NOT NULL ,emai VARCHAR( 100 ) NOT NULL ,dateOfBirth DATE NULL ,telephone VARCHAR( 100 ) NULL ,password VARCHAR( 100 ) NOT NULL ,about TEXT NULL , sex VARCHAR( 100 ) NULL ,skype VARCHAR( 100 ) NULL ,isq VARCHAR( 100 ) NULL ,IQ INT( 2 ) NULL, idStat INT( 10 ) NOT NULL ,picture BLOB NULL ,dateOfLastVisit DATE NULL ,numberOfCautions VARCHAR( 100 ) NULL)"; 

		Statement st = null;
		try {
			st = connection.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO wrong syntax
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
			}
		}

	}

	public User findUserById(long id) {
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String query = "Select * from users where id=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getLong(1));
				user.setName(rs.getString(2));
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
		}
		return null;
	}

}