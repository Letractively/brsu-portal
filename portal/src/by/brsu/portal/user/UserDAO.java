/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

package by.brsu.portal.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.brsu.portal.ConnectionManager;


/**
 * @author Hraznykh_Pavel
 * @version 20110824
 */
public class UserDAO {
	/**
	 * @param user
	 * @return user(+id)
	 * @author Aliaksei Ryzhkou
	 */
	public User createUser(User user) {
		Connection conn = ConnectionManager.getConnectorPool().getConnection();;
		String query = "insert into users values (null,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, user.getName());
			st.executeUpdate();
			st = conn.prepareStatement("select id from user where name=?");
			rs = st.executeQuery();
			if (rs.next()) {
				User tmp = new User();
				user.setName(user.getName());
				user.setId(rs.getLong(1));
				return tmp;
			}

		} catch (SQLException e) {
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
