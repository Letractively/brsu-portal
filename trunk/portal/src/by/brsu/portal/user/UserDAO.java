package by.brsu.portal.user;

import java.sql.*;

import by.brsu.portal.ConnectionManager;

public class UserDAO {
	public void deleteTable(){
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "drop table users";
		Statement st=null;
		 try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (st!=null)
				st.close();
			} catch (SQLException e) {
			}
		}
		
	}
	public void addTable(){
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "create table users(id int not null auto_increment key,name char(30))";
		Statement st=null;
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO wrong syntax
		}finally{
			try {
				if (st!=null)
					st.close();
			} catch (SQLException e) {
			}
		}
		
	}
	public User createUser(String name) {
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into users values (null,'" + name + "')";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
			st = connection.createStatement();
			rs = st.executeQuery("Select id from users where name='" + name
					+ "'");
			if (rs.next()) {
				User user = new User();
				user.setName(name);
				user.setId(rs.getLong(1));
				return user;
			}

		} catch (SQLException e) {
			//TODO log error
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

	public User createUserPrepared(String name) {
		// Connection connection =
		// DriverManager.getConnection("jdbc:mysql://localhost/jdbctest",
		// "root", "root");
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into users values (null,?)";
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			pst.executeUpdate(sql);

			st = connection.createStatement();
			rs = st.executeQuery("Select id from users where name='" + name
					+ "'");
			if (rs.next()) {
				User user = new User();
				user.setName(name);
				user.setId(rs.getLong(1));
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
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	public User findUserById(long id) {
		Connection connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from users where id=" + id;
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
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
}
