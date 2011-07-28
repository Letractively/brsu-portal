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

/**
 * @author Roman Ulezlo
 * 
 */
public class UserHistoryDAO implements IUserHistoryDAO{
	private Connection conn = null;

	/**
	 * Add record about user in history
	 * 
	 * @param name
	 *            String - name of user history
	 */
	public UserHistory createUserHistory(long idUser, java.sql.Date date,
			String name, String surname, long idStatus, int iq,
			int numberOfCations) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into UserHistory values (null,?,?,?,?,?,?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		long id;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, idUser);
			st.setDate(2, date);
			st.setString(3, name);
			st.setString(4, surname);
			st.setLong(5, idStatus);
			st.setInt(6, iq);
			st.setInt(7, numberOfCations);
			st.executeUpdate();
			st = conn
					.prepareStatement("select max(id_usr_history) from UserHistory");
			rs = st.executeQuery();
			rs.next();
			id = rs.getLong(1);
			UserHistory ush = new UserHistory();
			ush.setId(id);
			ush.setIdUser(idUser);
			ush.setDate(date);
			ush.setName(name);
			ush.setSurname(surname);
			ush.setIdStatus(idStatus);
			ush.setIq(iq);
			ush.setNumberOfCations(numberOfCations);
			return ush;
		} catch (SQLException ex) {
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
	 * Delete user history
	 * 
	 * @param id
	 *            - id user history
	 */
	public void deleteUserHistory(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from UserHistory where id_usr_history=?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
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
	 * Find user history by id
	 * 
	 * @param id
	 *            - id user history
	 */
	public UserHistory findUserHistoryById(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_history,id_user,date,name,surname,id_status,iq,number_of_cations from UserHistory where id_usr_history=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				UserHistory ush = new UserHistory();
				ush.setId(id);
				ush.setIdUser(rs.getLong(2));
				ush.setDate(rs.getDate(3));
				ush.setName(rs.getString(4));
				ush.setSurname(rs.getString(5));
				ush.setIdStatus(rs.getLong(6));
				ush.setIq(rs.getInt(7));
				ush.setNumberOfCations(rs.getInt(8));
				return ush;
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
	 * Find user history by id of user
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByIdUser(long idUser) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_history,id_user,date,name,surname,id_status,iq,number_of_cations from UserHistory where id_user=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, idUser);
			rs = st.executeQuery();
			List<UserHistory> prh = new ArrayList<UserHistory>();
			UserHistory tempush = new UserHistory();
			if (rs.next()) {
				tempush.setId(rs.getLong(1));
				tempush.setIdUser(rs.getLong(2));
				tempush.setDate(rs.getDate(3));
				tempush.setName(rs.getString(4));
				tempush.setSurname(rs.getString(5));
				tempush.setIdStatus(rs.getLong(6));
				tempush.setIq(rs.getInt(7));
				tempush.setNumberOfCations(rs.getInt(8));
				prh.add(tempush);
			}
			return prh;
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
	 * Find user history by date
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByDate(Date date) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_history,id_user,date,name,surname,id_status,iq,number_of_cations from UserHistory where date=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setDate(1, date);
			rs = st.executeQuery();
			List<UserHistory> prh = new ArrayList<UserHistory>();
			UserHistory tempush = new UserHistory();
			if (rs.next()) {
				tempush.setId(rs.getLong(1));
				tempush.setIdUser(rs.getLong(2));
				tempush.setDate(rs.getDate(3));
				tempush.setName(rs.getString(4));
				tempush.setSurname(rs.getString(5));
				tempush.setIdStatus(rs.getLong(6));
				tempush.setIq(rs.getInt(7));
				tempush.setNumberOfCations(rs.getInt(8));
				prh.add(tempush);
			}
			return prh;
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
	 * Find user history by name
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByName(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_history,id_user,date,name,surname,id_status,iq,number_of_cations from UserHistory where name=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			List<UserHistory> prh = new ArrayList<UserHistory>();
			UserHistory tempush = new UserHistory();
			if (rs.next()) {
				tempush.setId(rs.getLong(1));
				tempush.setIdUser(rs.getLong(2));
				tempush.setDate(rs.getDate(3));
				tempush.setName(rs.getString(4));
				tempush.setSurname(rs.getString(5));
				tempush.setIdStatus(rs.getLong(6));
				tempush.setIq(rs.getInt(7));
				tempush.setNumberOfCations(rs.getInt(8));
				prh.add(tempush);
			}
			return prh;
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
	 * Find user history by name
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryBySurame(String surname) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_history,id_user,date,name,surname,id_status,iq,number_of_cations from UserHistory where surname=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, surname);
			rs = st.executeQuery();
			List<UserHistory> prh = new ArrayList<UserHistory>();
			UserHistory tempush = new UserHistory();
			if (rs.next()) {
				tempush.setId(rs.getLong(1));
				tempush.setIdUser(rs.getLong(2));
				tempush.setDate(rs.getDate(3));
				tempush.setName(rs.getString(4));
				tempush.setSurname(rs.getString(5));
				tempush.setIdStatus(rs.getLong(6));
				tempush.setIq(rs.getInt(7));
				tempush.setNumberOfCations(rs.getInt(8));
				prh.add(tempush);
			}
			return prh;
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
	 * Find user history by id of status
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByIdStatus(int status) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_history,id_user,date,name,surname,id_status,iq,number_of_cations from UserHistory where id_status=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, status);
			rs = st.executeQuery();
			List<UserHistory> prh = new ArrayList<UserHistory>();
			UserHistory tempush = new UserHistory();
			if (rs.next()) {
				tempush.setId(rs.getLong(1));
				tempush.setIdUser(rs.getLong(2));
				tempush.setDate(rs.getDate(3));
				tempush.setName(rs.getString(4));
				tempush.setSurname(rs.getString(5));
				tempush.setIdStatus(rs.getLong(6));
				tempush.setIq(rs.getInt(7));
				tempush.setNumberOfCations(rs.getInt(8));
				prh.add(tempush);
			}
			return prh;
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
	 * Find user history by IQ
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByIq(int iq) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_history,id_user,date,name,surname,id_status,iq,number_of_cations from UserHistory where iq=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, iq);
			rs = st.executeQuery();
			List<UserHistory> prh = new ArrayList<UserHistory>();
			UserHistory tempush = new UserHistory();
			if (rs.next()) {
				tempush.setId(rs.getLong(1));
				tempush.setIdUser(rs.getLong(2));
				tempush.setDate(rs.getDate(3));
				tempush.setName(rs.getString(4));
				tempush.setSurname(rs.getString(5));
				tempush.setIdStatus(rs.getLong(6));
				tempush.setIq(rs.getInt(7));
				tempush.setNumberOfCations(rs.getInt(8));
				prh.add(tempush);
			}
			return prh;
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
	 * Find user history by number of cations
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findUserHistoryByNumberOfCations(int numberOfCations) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_history,id_user,date,name,surname,id_status,iq,number_of_cations from UserHistory where iq=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, numberOfCations);
			rs = st.executeQuery();
			List<UserHistory> prh = new ArrayList<UserHistory>();
			UserHistory tempush = new UserHistory();
			if (rs.next()) {
				tempush.setId(rs.getLong(1));
				tempush.setIdUser(rs.getLong(2));
				tempush.setDate(rs.getDate(3));
				tempush.setName(rs.getString(4));
				tempush.setSurname(rs.getString(5));
				tempush.setIdStatus(rs.getLong(6));
				tempush.setIq(rs.getInt(7));
				tempush.setNumberOfCations(rs.getInt(8));
				prh.add(tempush);
			}
			return prh;
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
	 * Find all user history
	 * 
	 * @return list of user history
	 */
	public List<UserHistory> findAllUserHistory() {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_usr_history,id_user,date,name,surname,id_status,iq,number_of_cations from UserHistory ";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<UserHistory> prh = new ArrayList<UserHistory>();
			UserHistory tempush = new UserHistory();
			if (rs.next()) {
				tempush.setId(rs.getLong(1));
				tempush.setIdUser(rs.getLong(2));
				tempush.setDate(rs.getDate(3));
				tempush.setName(rs.getString(4));
				tempush.setSurname(rs.getString(5));
				tempush.setIdStatus(rs.getLong(6));
				tempush.setIq(rs.getInt(7));
				tempush.setNumberOfCations(rs.getInt(8));
				prh.add(tempush);
			}
			return prh;
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
