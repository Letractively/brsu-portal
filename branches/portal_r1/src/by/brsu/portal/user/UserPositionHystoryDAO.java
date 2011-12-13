/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

import java.sql.Connection;
import java.sql.Date;
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
public class UserPositionHystoryDAO implements IUserPositionHistoryDAO {
	private Connection conn = null;

	/**
	 * Add record about user position in history
	 * 
	 * @param name
	 *            String - name of user position history
	 * @throws PortalTechnicalException 
	 */
	public UserPositionHistory createUserPositionHistory(long idUser,
			Date date, long idPosition, long idProject) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into UserPositionHistory values (null,?,?,?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		long id;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, idUser);
			st.setDate(2, date);
			st.setLong(3, idPosition);
			st.setLong(4, idProject);
			st.executeUpdate();
			st = conn
					.prepareStatement("select max(id_usr_position_hist) from UserPositionHistory");
			rs = st.executeQuery();
			rs.next();
			id = rs.getLong(1);
			UserPositionHistory usprh = new UserPositionHistory();
			usprh.setId(id);
			usprh.setIdUser(idUser);
			usprh.setDate(date);
			usprh.setIdPosition(idPosition);
			usprh.setIdProject(idProject);
			return usprh;
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
	}

	/**
	 * Delete user position history
	 * 
	 * @param id
	 *            - id project history
	 * @throws PortalTechnicalException 
	 */
	public void deleteUserPositionHistory(long id) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from UserPositionHistory where id_usr_position_hist=?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
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
	 * Find user position history by id
	 * 
	 * @param id
	 *            - id user position history
	 * @throws PortalTechnicalException 
	 */
	public UserPositionHistory findUserPositionHistoryById(long id) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_position_hist,id_user,date,id_pos,id_project from UserPositionHistory where id_usr_position_hist=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				UserPositionHistory usprh = new UserPositionHistory();
				usprh.setId(id);
				usprh.setIdUser(rs.getLong(2));
				usprh.setDate(rs.getDate(3));
				usprh.setIdPosition(rs.getLong(4));
				usprh.setIdProject(rs.getLong(5));
				return usprh;
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
	 * Finds user position histories by id of user
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findUserPositionHistoryByIdUser(long idUser) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_position_hist,id_user,date,id_pos,id_project from UserPositionHistory where id_usr_position_hist=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, idUser);
			rs = st.executeQuery();
			List<UserPositionHistory> usprh = new ArrayList<UserPositionHistory>();
			UserPositionHistory tempusprh = new UserPositionHistory();
			if (rs.next()) {
				tempusprh.setId(rs.getLong(1));
				tempusprh.setIdUser(rs.getLong(2));
				tempusprh.setDate(rs.getDate(3));
				tempusprh.setIdPosition(rs.getLong(4));
				tempusprh.setIdProject(rs.getLong(5));
				usprh.add(tempusprh);
			}
			return usprh;
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

	/**
	 * Finds user position histories by date
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findUserPositionHistoryByDate(Date date) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_position_hist,id_user,date,id_pos,id_project from UserPositionHistory where date=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setDate(1, date);
			rs = st.executeQuery();
			List<UserPositionHistory> usprh = new ArrayList<UserPositionHistory>();
			UserPositionHistory tempusprh = new UserPositionHistory();
			if (rs.next()) {
				tempusprh.setId(rs.getLong(1));
				tempusprh.setIdUser(rs.getLong(2));
				tempusprh.setDate(rs.getDate(3));
				tempusprh.setIdPosition(rs.getLong(4));
				tempusprh.setIdProject(rs.getLong(5));
				usprh.add(tempusprh);
			}
			return usprh;
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

	/**
	 * Finds user position histories by id of position
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findUserPositionHistoryByIdPosition(
			long idPosition) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_position_hist,id_user,date,id_pos,id_project from UserPositionHistory where id_pos=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, idPosition);
			rs = st.executeQuery();
			List<UserPositionHistory> usprh = new ArrayList<UserPositionHistory>();
			UserPositionHistory tempusprh = new UserPositionHistory();
			if (rs.next()) {
				tempusprh.setId(rs.getLong(1));
				tempusprh.setIdUser(rs.getLong(2));
				tempusprh.setDate(rs.getDate(3));
				tempusprh.setIdPosition(rs.getLong(4));
				tempusprh.setIdProject(rs.getLong(5));
				usprh.add(tempusprh);
			}
			return usprh;
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

	/**
	 * Finds user position histories by id of project
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findUserPositionHistoryByIdProject(
			long idProject) throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_position_hist,id_user,date,id_pos,id_project from UserPositionHistory where id_project=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, idProject);
			rs = st.executeQuery();
			List<UserPositionHistory> usprh = new ArrayList<UserPositionHistory>();
			UserPositionHistory tempusprh = new UserPositionHistory();
			if (rs.next()) {
				tempusprh.setId(rs.getLong(1));
				tempusprh.setIdUser(rs.getLong(2));
				tempusprh.setDate(rs.getDate(3));
				tempusprh.setIdPosition(rs.getLong(4));
				tempusprh.setIdProject(rs.getLong(5));
				usprh.add(tempusprh);
			}
			return usprh;
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

	/**
	 * Finds all users position histories
	 * 
	 * @return list of user position history
	 * @throws PortalTechnicalException 
	 */
	public List<UserPositionHistory> findAllUserPositionHistory() throws PortalTechnicalException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_position_hist,id_user,date,id_pos,id_project from UserPositionHistory";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<UserPositionHistory> usprh = new ArrayList<UserPositionHistory>();
			UserPositionHistory tempusprh = new UserPositionHistory();
			if (rs.next()) {
				tempusprh.setId(rs.getLong(1));
				tempusprh.setIdUser(rs.getLong(2));
				tempusprh.setDate(rs.getDate(3));
				tempusprh.setIdPosition(rs.getLong(4));
				tempusprh.setIdProject(rs.getLong(5));
				usprh.add(tempusprh);
			}
			return usprh;
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
