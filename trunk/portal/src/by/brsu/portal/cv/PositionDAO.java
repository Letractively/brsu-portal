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
public class PositionDAO implements IPositionDAO {
	private Connection conn = null;

	/**
	 * Add position
	 * 
	 * @param name
	 *            String - name of position
	 * @throws PortalTechnicalException
	 */
	public Position createPosition(String name) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into positions values (null,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
			st = conn
					.prepareStatement("select id_pos from positions where name=?");
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				Position pos = new Position();
				pos.setName(name);
				pos.setId(rs.getLong(1));
				return pos;
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
	 * Delete position
	 * 
	 * @param name
	 *            - name of position
	 * @throws PortalTechnicalException
	 */
	public void deletePosition(String name) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from positions where name=?";
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
	 * Find position by id
	 * 
	 * @param id
	 *            - id of position
	 * @throws PortalTechnicalException
	 */
	public Position findPositionById(long id) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pos, name from positions where id_pos=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Position pos = new Position();
				pos.setId(rs.getLong(1));
				pos.setName(rs.getString(2));
				return pos;
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
	 * Find position by name
	 * 
	 * @param name
	 *            - name of position
	 * @throws PortalTechnicalException
	 */
	public Position findPositionByName(String name)
			throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pos, name from positions where name=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				Position pos = new Position();
				pos.setId(rs.getLong(1));
				pos.setName(rs.getString(2));
				return pos;
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
	 * Finds all positions
	 * 
	 * @return list of positions
	 * @throws PortalTechnicalException
	 */
	public List<Position> findAllPosition(){
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pos, name from positions";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<Position> positions = new ArrayList<Position>();
			while (rs.next()) {
				Position temppos = new Position();
				temppos.setId(rs.getLong(1));
				temppos.setName(rs.getString(2));
				positions.add(temppos);
			}
			return positions;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
		return null;
	}
}
