/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.brsu.portal.ConnectionManager;

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
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into technologies values (?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(2, name);
			st.executeUpdate();
			st = conn.prepareStatement("");
			rs = st.executeQuery("Select id from technologies where name='"
					+ name + "'");
			if (rs.next()) {
				Technology techn = new Technology();
				techn.setName(name);
				techn.setId(rs.getLong(1));
				return techn;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from technology where name='" + name + "'";
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * Find technology by id
	 * 
	 * @param id
	 *            - id of technology
	 */
	public Technology findTechnologyById(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
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
		}
		return null;
	}

	/**
	 * Find technology by name
	 * 
	 * @param name
	 *            - name of technology
	 */
	public Technology findTechnologyByName(String name)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from technology where name=" + name;
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
		}
		return null;
	}

}
