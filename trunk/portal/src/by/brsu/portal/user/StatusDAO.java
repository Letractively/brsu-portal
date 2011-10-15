/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;


/**
 * @author Hraznykh_Pavel
 * 
 */
public class StatusDAO {
	private static final Logger log = Logger.getLogger(StatusDAO.class);

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
	 * @throws IOException
	 */
	public Status createStatus(String name) throws SQLException, IOException {

		Connection conn = null;
		conn = Connect();
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		String query = "insert into status values (null,'" + name + "')";
		ResultSet rs = null;
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT id FROM status where name='" + name
					+ "'");
			if (rs.next()) {
				Status st = new Status();
				st.setName(rs.getString(name));
				st.setIdStat(rs.getLong(1));
				return st;
			}

		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				log.error(e);
			}

		}
		return null;
	}

	/**
	 * Delete database
	 * 
	 * @throws IOException
	 */
	public void delTable() throws SQLException, IOException {
		Connection conn = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		conn = Connect();
		String query = "DROP TABLE USERS";
		Statement stat = null;

		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			log.error(e);
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
	 * 
	 * @throws IOException
	 */
	public void addTable() throws SQLException, IOException {
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		Connection conn = null;
		String query = "CREATE TABLE Status(idStat int not null auto_increment primary key, name varchar(100) not null)";
		Statement stat = null;
		conn = Connect();
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			log.error(e);
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
	 * @throws IOException
	 */
	public void delStatus(String name) throws SQLException, IOException {

		Connection conn = null;
		conn = Connect();
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		String query = "DELETE FROM status WHERE name='" + name + "'";
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			log.error(e);
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
	 * @throws IOException
	 */
	public Status findStatusById(long id) throws SQLException, IOException {

		Connection conn = null;
		conn = Connect();
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
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
			log.error(e);
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
