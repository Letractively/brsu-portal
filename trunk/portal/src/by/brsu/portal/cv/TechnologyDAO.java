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
	 */
	public Technology createTechnology(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into technologies values (null,?)";
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.executeUpdate();
			pst = conn.prepareStatement("");
			rs = pst.executeQuery("select id_tech from technologies where name='"
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
				if (pst != null)
					pst.close();
			} catch (SQLException ex) {
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
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from technologies where name='" + name + "'";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.executeUpdate();
		} catch (SQLException e) {
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException ex) {
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
		String sql = "select id_tech, name from technologies where id=" + id;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Technology techn = new Technology();
				techn.setId(rs.getLong(1));
				techn.setName(rs.getString(2));
				return techn;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find technology by name
	 * 
	 * @param name
	 *            - name of technology
	 */
	public Technology findTechnologyByName(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_tech, name from technologies where name='"
				+ name + "'";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Technology techn = new Technology();
				techn.setId(rs.getLong(1));
				techn.setName(rs.getString(2));
				return techn;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find all technologies
	 * 
	 * @return list of technologies
	 */
	public List<Technology> findAllTechologies() {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from technologies";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			List<Technology> techn = new ArrayList<Technology>();
			Technology temptechn = new Technology();
			if (rs.next()) {
				temptechn.setId(rs.getLong(1));
				temptechn.setName(rs.getString(2));
				techn.add(temptechn);
			}
			return techn;
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException ex) {
			}
		}
		return null;
	}
}
