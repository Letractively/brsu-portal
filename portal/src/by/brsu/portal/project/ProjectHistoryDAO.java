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

/**
 * @author Roman Ulezlo
 * 
 */
public class ProjectHistoryDAO {
	private Connection conn = null;

	/**
	 * Add record about project in history
	 * 
	 * @param name
	 *            String - name of project history
	 */
	public ProjectHistory createProjectHistory(long project, long user,
			String stage, String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into ProjectHistory values (null,?,?,?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		long id;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, project);
			st.setLong(2, user);
			st.setString(3, stage);
			st.setString(4, name);
			st.executeUpdate();
			st = conn
					.prepareStatement("select max(id_pr_history) from projecthistory");
			rs = st.executeQuery();
			rs.next();
			id = rs.getLong(1);
			st = conn
					.prepareStatement("select id_pr_history,id_project,id_user,stage,name from projecthistory where id_pr_history="
							+ id);
			rs = st.executeQuery();
			if (rs.next()) {
				ProjectHistory prh = new ProjectHistory();				
				prh.setId(id);
				prh.setProject(project);
				prh.setUser(user);
				prh.setStage(rs.getString(4));
				prh.setName(name);
				return prh;
			}
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
	 * Delete project history
	 * 
	 * @param id
	 *            - id project history
	 */
	public void deleteProjectHistory(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from projecthistory where id_pr_history=?";
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
	 * Find project history by id
	 * 
	 * @param id
	 *            - id project history
	 */
	public ProjectHistory findProjectHistoryById(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pr_history,id_project,id_user,stage,name from projecthistory where id_pr_history=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				ProjectHistory prh = new ProjectHistory();
				prh.setId(id);
				prh.setProject(rs.getLong(2));
				prh.setUser(rs.getLong(3));
				prh.setStage(rs.getString(4));
				prh.setName(rs.getString(5));
				return prh;
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
	 * Find project history by id of user
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findProjectHistoryByIdUser(long idUser) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pr_history,id_project,id_user,stage,name from projecthistory where id_user=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, idUser);
			rs = st.executeQuery();
			List<ProjectHistory> prh = new ArrayList<ProjectHistory>();
			ProjectHistory tempprh = new ProjectHistory();
			if (rs.next()) {
				tempprh.setId(rs.getLong(1));
				tempprh.setProject(rs.getLong(2));
				tempprh.setUser(idUser);
				tempprh.setStage(rs.getString(4));
				tempprh.setName(rs.getString(5));
				prh.add(tempprh);
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
	 * Find project history by id of project
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findProjectHistoryByIdProject(long idProject) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pr_history,id_project,id_user,stage,name from projecthistory where id_project=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, idProject);
			rs = st.executeQuery();
			List<ProjectHistory> prh = new ArrayList<ProjectHistory>();
			ProjectHistory tempprh = new ProjectHistory();
			if (rs.next()) {
				tempprh.setId(rs.getLong(1));
				tempprh.setProject(idProject);
				tempprh.setUser(rs.getLong(3));
				tempprh.setStage(rs.getString(4));
				tempprh.setName(rs.getString(5));
				prh.add(tempprh);
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
	 * Find project history by name
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findProjectHistoryByName(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pr_history,id_project,id_user,stage,name from projecthistory where name=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			List<ProjectHistory> prh = new ArrayList<ProjectHistory>();
			ProjectHistory tempprh = new ProjectHistory();
			if (rs.next()) {
				tempprh.setId(rs.getLong(1));
				tempprh.setProject(rs.getLong(2));
				tempprh.setUser(rs.getLong(3));
				tempprh.setStage(rs.getString(4));
				tempprh.setName(name);
				prh.add(tempprh);
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
	 * Find project history by stage
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findProjectHistoryByStage(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pr_history,id_project,id_user,stage,name from projecthistory where stage=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			List<ProjectHistory> prh = new ArrayList<ProjectHistory>();
			ProjectHistory tempprh = new ProjectHistory();
			if (rs.next()) {
				tempprh.setId(rs.getLong(1));
				tempprh.setProject(rs.getLong(2));
				tempprh.setUser(rs.getLong(3));
				tempprh.setStage(rs.getString(4));
				tempprh.setName(name);
				prh.add(tempprh);
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
	 * Find all project history by stage
	 * 
	 * @return list of project history
	 */
	public List<ProjectHistory> findAllProjectHistory() {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select id_pr_history,id_project,id_user,stage,name from projecthistory";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<ProjectHistory> prh = new ArrayList<ProjectHistory>();
			ProjectHistory tempprh = new ProjectHistory();
			if (rs.next()) {
				tempprh.setId(rs.getLong(1));
				tempprh.setProject(rs.getLong(2));
				tempprh.setUser(rs.getLong(3));
				tempprh.setStage(rs.getString(4));
				tempprh.setName(rs.getString(5));
				prh.add(tempprh);
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
