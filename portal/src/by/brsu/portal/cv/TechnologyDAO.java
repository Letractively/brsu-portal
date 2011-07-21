/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Roman Ulezlo
 * 
 */
public class TechnologyDAO {
	private Connection conn = null;

	/**
	 * Add technology
	 * 
	 * @param name
	 *            String - name of technology
	 */
	public Technology createTechnology(String name) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/main",
					"root", "root");
		} catch (SQLException ex) {
		}
		String sql = "insert into technologies values (null,'" + name + "')";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			st = conn.createStatement();
			rs = st.executeQuery("Select id from technologies where name='"
					+ name + "'");
			if (rs.next()) {
				Technology techn = new Technology();
				techn.setName(name);
				techn.setId(rs.getLong(1));
				return techn;
			}

		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * Delete technology
	 * 
	 * @param name
	 *            - name of technology
	 */
	public void deleteTechnology(String name) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/main",
					"root", "root");
		} catch (SQLException ex) {
		}
		String sql = "delete from technology where name='" + name + "'";
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
			}
		}
	}

	/**
	 * Find technology by id
	 * 
	 * @param id
	 *            - id of technology
	 */
	public Technology findTechnologyById(long id) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/main",
					"root", "root");
		} catch (SQLException ex) {
		}
		String sql = "Select * from technology where id=" + id;
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Technology techn = new Technology();
				techn.setId(rs.getLong(1));
				techn.setName(rs.getString(2));
				return techn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
			}
		}
		return null;
	}

}
