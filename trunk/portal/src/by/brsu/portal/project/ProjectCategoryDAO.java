/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.brsu.portal.ConnectionManager;
import by.brsu.portal.PortalTechnicalException;

/**
 * @author Roman Ulezlo
 * 
 */
public class ProjectCategoryDAO implements IProjectCategoryDAO {
	private Connection conn = null;

	/**
	 * Add category project
	 * 
	 * @param name
	 *            String - name of category project
	 * @throws PortalTechnicalException
	 */
	public ProjectCategory createProjectCategory(String name)
			throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into categories_pr values (null,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
			st = conn
					.prepareStatement("select id_category from categories_pr where name=?");
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				ProjectCategory prc = new ProjectCategory();
				prc.setName(name);
				prc.setId(rs.getLong(1));
				return prc;
			}
		} catch (SQLException ex) {
			throw new PortalTechnicalException(
					"Error of performance of inquiry!");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException ex) {
				throw new PortalTechnicalException(
						"Error closing object ResultSet or PreparedStatement!");
			}
		}
		return null;
	}

	/**
	 * Delete category project
	 * 
	 * @param name
	 *            - name of category project
	 * @throws PortalTechnicalException
	 */
	public void deleteProjectCategory(String name)
			throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from categories_pr where name=?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new PortalTechnicalException(
					"Error of performance of inquiry!");
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException ex) {
				throw new PortalTechnicalException(
						"Error closing object PreparedStatement!");
			}
		}
	}

	/**
	 * Find category project by id
	 * 
	 * @param id
	 *            - id of category project
	 * @throws PortalTechnicalException
	 */
	public ProjectCategory findProjectCategoryById(long id)
			throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_category, name from categories_pr where id_category=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				ProjectCategory prc = new ProjectCategory();
				prc.setId(rs.getLong(1));
				prc.setName(rs.getString(2));
				return prc;
			}
		} catch (SQLException e) {
			throw new PortalTechnicalException(
					"Error of performance of inquiry!");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException ex) {
				throw new PortalTechnicalException(
						"Error closing object ResultSet or PreparedStatement!");
			}
		}
		return null;
	}

	/**
	 * Find category project by name
	 * 
	 * @param name
	 *            - name of category project
	 * @throws PortalTechnicalException
	 */
	public ProjectCategory findProjectCategoryByName(String name)
			throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_category, name from categories_pr where name=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				ProjectCategory prc = new ProjectCategory();
				prc.setId(rs.getLong(1));
				prc.setName(rs.getString(2));
				return prc;
			}
		} catch (SQLException e) {
			throw new PortalTechnicalException(
					"Error of performance of inquiry!");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException ex) {
				throw new PortalTechnicalException(
						"Error closing object ResultSet or PreparedStatement!");
			}
		}
		return null;
	}

	/**
	 * Finds all categories of project
	 * 
	 * @return list of categories of project
	 * @throws PortalTechnicalException
	 */
	public List<ProjectCategory> findAllProjectCategory()
			throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from categories_pr";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			List<ProjectCategory> techn = new ArrayList<ProjectCategory>();
			ProjectCategory tempcat = new ProjectCategory();
			if (rs.next()) {
				tempcat.setId(rs.getLong(1));
				tempcat.setName(rs.getString(2));
				techn.add(tempcat);
			}
			return techn;
		} catch (SQLException e) {
			throw new PortalTechnicalException(
					"Error of performance of inquiry!");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException ex) {
				throw new PortalTechnicalException(
						"Error closing object ResultSet or PreparedStatement!");
			}
		}
	}
}
