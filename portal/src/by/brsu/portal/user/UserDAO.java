package by.brsu.portal.user;

import java.sql.*;

import by.brsu.portal.ConnectionManager;

public class UserDAO {

	public User createUser(String name) {
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String query = "insert into users values (?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(query);
			st.setString(1, name);
			st.executeUpdate();
			st = conn.prepareStatement("");
			rs = st.executeQuery("Select idUser from position where name='" + name + "'");
			if (rs.next()) {
				User user = new User();
				user.setName(name);
				user.setId(rs.getLong(1));
				return user;
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

	public void deleteUser(long idUser) {
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String query = "delete from position where idUser='" + idUser + "'";";
		Statement st = null;
		try {
			st = connection.createStatement();
			st.executeUpdate(query);
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
		String query = "create table users(idUser int not null auto_increment PRIMARY key, name char(30), NOT NULL, surname VARCHAR( 100 ) NOT NULL ,emai VARCHAR( 100 ) NOT NULL ,dateOfBirth DATE NULL ,telephone VARCHAR( 100 ) NULL ,password VARCHAR( 100 ) NOT NULL ,about TEXT NULL , sex VARCHAR( 100 ) NULL ,skype VARCHAR( 100 ) NULL ,isq VARCHAR( 100 ) NULL ,IQ INT( 2 ) NULL, idStat INT( 10 ) NOT NULL ,picture BLOB NULL ,dateOfLastVisit DATE NULL ,numberOfCautions VARCHAR( 100 ) NULL)"; 

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

	public User findUserById(long idUser) {
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String query = "Select * from users where idUser=" + idUser;
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				User user = new User();
				user.setIdUser(rs.getLong(1));
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
		conn = ConnectionManager.getConnectorPool().getConnection();
		String query = "Select * from position where name=" + name;
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				ProjectCategory pos = new ProjectCategory();
				pos.setIdUser(rs.getLong(1));
				pos.setName(rs.getString(2));
				return pos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}

}
