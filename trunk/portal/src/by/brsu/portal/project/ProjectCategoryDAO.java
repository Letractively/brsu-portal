/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

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
public class ProjectCategoryDAO {
	private Connection conn = null;

	/**
	 * Add category project
	 * 
	 * @param name
	 *            String - name of category project
	 */
	public ProjectCategory createProjectCategory(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into categories_pr values (?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(2, name);
			st.executeUpdate();
			st = conn.prepareStatement("");
			rs = st.executeQuery("Select id from categories_pr where name='"
					+ name + "'");
			if (rs.next()) {
				ProjectCategory prc = new ProjectCategory();
				prc.setName(name);
				prc.setId(rs.getLong(1));
				return prc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}

	/**
	 * Delete category project
	 * 
	 * @param name
	 *            - name of category project
	 */
	public void deleteProjectCategory(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from categories_pr where name='" + name + "'";
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
	 * Find category project by id
	 * 
	 * @param id
	 *            - id of category project
	 */
	public ProjectCategory findProjectCategoryById(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from categories_pr where id=" + id;
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				ProjectCategory prc = new ProjectCategory();
				prc.setId(rs.getLong(1));
				prc.setName(rs.getString(2));
				return prc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}

	/**
	 * Find category project by name
	 * 
	 * @param name
	 *            - name of category project
	 */
	public ProjectCategory findProjectCategoryByName(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from categories_pr where name=" + name;
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				ProjectCategory prc = new ProjectCategory();
				prc.setId(rs.getLong(1));
				prc.setName(rs.getString(2));
				return prc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}
}
