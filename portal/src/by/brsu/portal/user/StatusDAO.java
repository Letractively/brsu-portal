/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Hraznykh_Pavel
 * 
 */
public class StatusDAO {

	/**
	 * Connect
	 * 
	 * @return connection
	 */
	private static Connection Connect() {
		Connection conn = null;
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/main";
			conn = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}
		return conn;
	}

	/**
	 * Create Status
	 * 
	 * @param name
	 *            String - name of Status
	 */
	public Status createStatus(String name) throws SQLException {

		Connection conn = null;
		conn = Connect();

		String query = "insert into status values (null,'" + name + "')";
		ResultSet rs = null;
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT id FROM status where name='" + name + "'");
			if (rs.next()) {
				Status st = new Status();
				st.setName(rs.getString(name));
				st.setIdStat(rs.getLong(1));
				return st;
			}

		} 
		catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * Delete database
	 */
	public void delTable() throws SQLException {
		Connection conn = null;

		conn = Connect();
		String query = "DROP TABLE USERS";
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
		}
	}

	/**
	 * Add table to database
	 */
	public void addTable() throws SQLException {

		Connection conn = null;
		String query = "CREATE TABLE Status(idStat int not null auto_increment primary key, name varchar(100) not null)";
		Statement stat = null;
		conn = Connect();
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
		}
	}

	/**
	 * Delete Status
	 * 
	 * @param name
	 *            name of Status
	 */
	public void delStatus(String name)throws SQLException {

		Connection conn = null;
		conn = Connect();

		String query = "DELETE FROM status WHERE name='" + name + "'";
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
		}
	}

	/**
	 * Find status by id
	 * 
	 * @param id
	 *            id of status
	 */
	public Status findStatusById(long id) throws SQLException {

		Connection conn = null;
		conn = Connect();

		String query = "SELECT * FROM status WHERE id=" + id;
		ResultSet rs = null;
		Statement stat = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(query);
			if (rs.next()) {
				Status st = new Status();
				st.setIdStat(rs.getLong(1));
				st.setName(rs.getString(2));
				return st;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
			}
		}
		return null;
	}

}
