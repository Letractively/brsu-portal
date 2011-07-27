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
import java.util.ArrayList;
import java.util.List;

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
	public Position createPosition(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into positions values (null,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
			st = conn.prepareStatement("");
			rs = st.executeQuery("select id_pos from positions where name='"
					+ name + "'");
			if (rs.next()) {
				Position pos = new Position();
				pos.setName(name);
				pos.setId(rs.getLong(1));
				return pos;
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
	 * Delete position
	 * 
	 * @param name
	 *            - name of position
	 */
	public void deletePosition(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from positions where name='" + name + "'";
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
	 * Find position by id
	 * 
	 * @param id
	 *            - id of position
	 */
	public Position findPositionById(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pos, name from positions where id_pos=" + id;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Position pos = new Position();
				pos.setId(rs.getLong(1));
				pos.setName(rs.getString(2));
				return pos;
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
	 * Find position by name
	 * 
	 * @param name
	 *            - name of position
	 */
	public Position findPositionByName(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pos, name from positions where name=" + name;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Position pos = new Position();
				pos.setId(rs.getLong(1));
				pos.setName(rs.getString(2));
				return pos;
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
	 * Find all positions
	 * 
	 * @return list of positions
	 */
	public List<Position> findAllPosition() {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pos, name from technologies";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			List<Position> positions = new ArrayList<Position>();
			Position temppos = new Position();
			if (rs.next()) {
				temppos.setId(rs.getLong(1));
				temppos.setName(rs.getString(2));
				positions.add(temppos);
			}
			return positions;
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
