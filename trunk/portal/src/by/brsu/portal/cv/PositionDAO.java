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
import by.brsu.portal.project.ProjectCategory;

/**
 * @author Roman Ulezlo
 *
 */
public class PositionDAO {
	private Connection conn = null;

	/**
	 * Add position
	 * 
	 * @param name
	 *            String - name of position
	 */
	public ProjectCategory createPosition(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into position values (?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(2, name);
			st.executeUpdate();
			st = conn.prepareStatement("");
			rs = st.executeQuery("Select id from position where name='"
					+ name + "'");
			if (rs.next()) {
				ProjectCategory pos = new ProjectCategory();
				pos.setName(name);
				pos.setId(rs.getLong(1));
				return pos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}

	/**
	 * Delete position
	 * 
	 * @param name
	 *            - name of position
	 */
	public void deletePosition(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from position where name='" + name + "'";
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
	 * Find position by id
	 * 
	 * @param id
	 *            - id of position
	 */
	public ProjectCategory findPositionById(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from position where id=" + id;
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				ProjectCategory pos = new ProjectCategory();
				pos.setId(rs.getLong(1));
				pos.setName(rs.getString(2));
				return pos;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}

	/**
	 * Find position by name
	 * 
	 * @param name
	 *            - name of position
	 */
	public ProjectCategory findPositionByName(String name)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from position where name=" + name;
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				ProjectCategory pos = new ProjectCategory();
				pos.setId(rs.getLong(1));
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
