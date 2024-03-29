/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

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
public class TechnologyDAO implements ITechnologyDAO {
	private Connection conn = null;

	/**
	 * Add technology
	 * 
	 * @param name
	 *            String - name of technology
	 * @throws PortalTechnicalException
	 */
	public Technology createTechnology(String name)
			throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into technologies values (null,?)";
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.executeUpdate();
			pst = conn
					.prepareStatement("select id_tech from technologies where name=?");
			pst.setString(1, name);
			rs = pst.executeQuery();
			if (rs.next()) {
				Technology techn = new Technology();
				techn.setName(name);
				techn.setId(rs.getLong(1));
				return techn;
			}
		} catch (SQLException e) {
			throw new PortalTechnicalException(
					"Error of performance of inquiry!");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
			} catch (SQLException ex) {
				throw new PortalTechnicalException(
						"Error closing object ResultSet or PreparedStatement!");
			}
		}
		return null;
	}

	/**
	 * Delete technology
	 * 
	 * @param name
	 *            - name of technology
	 * @throws PortalTechnicalException
	 */
	public void deleteTechnology(String name) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from technologies where name=?";
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
	 * Find technology by id
	 * 
	 * @param id
	 *            - id of technology
	 */
	public Technology findTechnologyById(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select * from technologies where id_tech=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Technology techn = new Technology();
				techn.setId(rs.getLong(1));
				techn.setName(rs.getString(2));
				return techn;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ConnectionManager.getConnectorPool().releaseConnection(conn);
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		return null;
	}

	/**
	 * Find technology by name
	 * 
	 * @param name
	 *            - name of technology
	 * @throws PortalTechnicalException
	 */
	public Technology findTechnologyByName(String name)
			throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_tech, name from technologies where name=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				Technology techn = new Technology();
				techn.setId(rs.getLong(1));
				techn.setName(rs.getString(2));
				return techn;
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
	 * Finds all technologies
	 * 
	 * @return list of technologies
	 * @throws PortalTechnicalException
	 */
	public List<Technology> findAllTechologies()
	/* throws PortalTechnicalException */{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from technologies";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			List<Technology> techn = new ArrayList<Technology>();
			while (rs.next()) {
				Technology temptechn = new Technology();
				temptechn.setId(rs.getLong(1));
				temptechn.setName(rs.getString(2));
				techn.add(temptechn);
			}
			return techn;
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			try {
				ConnectionManager.getConnectorPool().releaseConnection(conn);
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		return null;
	}

	public List<Technology> findTechnologiesByProjectId(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select technologies.id_tech, name from technologies inner join l_technologies_pr on l_technologies_pr.id_tech=technologies.id_tech where l_technologies_pr.id_project=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			List<Technology> technologies = new ArrayList<Technology>();
			while (rs.next()) {
				Technology technology = new Technology();
				technology.setId(rs.getLong(1));
				technology.setName(rs.getString(2));
				technologies.add(technology);
			}
			return technologies;
		} catch (SQLException e) {
			System.out.print(e);
		} finally {
			try {
				ConnectionManager.getConnectorPool().releaseConnection(conn);
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		return null;
	}
}
