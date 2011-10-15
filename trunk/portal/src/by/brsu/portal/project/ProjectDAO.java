/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import by.brsu.portal.ConnectionManager;
import by.brsu.portal.cv.ProgrammingLanguage;
import by.brsu.portal.cv.Technology;

/**
 * @author Artur Smaliuk
 * 
 */
public class ProjectDAO {
	private Connection conn = null;
	private static final Logger log = Logger.getLogger(ProjectDAO.class);

	/**
	 * Add project
	 * 
	 */
	public Project createProject(int User, String name, String description,
			Date dateOfCreation, Date dateOfClosing, ProjectCategory category,
			int version, String license, String stageOfDevelopment,
			List<Technology> technology, List<ProgrammingLanguage> languages) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into Projects values (?,?,?,?,?,?,?,?,?,?,?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(2, name);
			st.executeUpdate();
			st = conn.prepareStatement("");
			rs = st.executeQuery("Select id from Projects where name=?");
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(User);
				proj.setName(name);
				proj.setDescription(description);
				proj.setDateOfCreation(dateOfCreation);
				proj.setDateOfClosing(dateOfClosing);
				proj.setCategory(category);
				proj.setVersion(version);
				proj.setLicense(license);
				proj.setStageOfDevelopment(stageOfDevelopment);
				proj.setTechnology(technology);
				proj.setLanguages(languages);
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	public Project createProject(Project project, String[] tech, String[] prlang)
			throws IOException {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "INSERT INTO Projects VALUES (null,?,?,?,?,null,?,?,?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			st = conn.prepareStatement(sql);
			int i = 1;
			st.setLong(i++, project.getUser());
			st.setString(i++, project.getName());
			st.setString(i++, project.getDescription());
			st.setDate(i++, new java.sql.Date(System.currentTimeMillis()));
			// st.setDate(5, (java.sql.Date) project.getDateOfClosing());
			ProjectCategory pc = project.getCategory();
			st.setString(i++, pc.getName());
			st.setLong(i++, project.getVersion());
			st.setString(i++, project.getLicense());
			st.setString(i++, project.getStageOfDevelopment());

			/*
			 * List<Technology> th = project.getTechnology(); String thnew =
			 * null; for (int i=1; i <= th.size(); i++) { thnew += th.get(i); }
			 * st.setString(11, thnew); List<ProgrammingLanguage> pl =
			 * project.getLanguages(); thnew = null; for (int i=1; i <=
			 * pl.size(); i++) { thnew += pl.get(i); } st.setString(12, thnew);
			 */
			st.executeUpdate();
			return project;
			/*
			 * st.setString(2, project.getName()); st.executeUpdate(); st =
			 * conn.prepareStatement(""); rs =
			 * st.executeQuery("Select id from Projects where name=?"); if
			 * (rs.next()) { Project proj = new Project();
			 * proj.setIdProject(rs.getLong(1));
			 * proj.setIdOwner(project.getIdOwner());
			 * proj.setName(project.getIdOwner());
			 * proj.setDescription(project.getDescription());
			 * proj.setDateOfCreation(project.getDateOfCreation());
			 * proj.setDateOfClosing(project.getDateOfClosing());
			 * proj.setCategory(project.getCategory());
			 * proj.setVersion(project.getVersion());
			 * proj.setLicense(project.getLicense());
			 * proj.setStageOfDevelopment(project.getStageOfDevelopment());
			 * proj.setTechnology(project.getTechnology());
			 * proj.setLanguages(project.getLanguages()); return proj; }
			 */
		} catch (SQLException e) {
			log.error(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}

		/*
		 * sql = "Select * from Projects where name=project.getName()"; rs =
		 * null; Statement sts = null; Long idi = null; try { sts =
		 * conn.createStatement(); rs = st.executeQuery(sql); idi =
		 * rs.getLong(1); } catch (SQLException e) { }
		 * 
		 * sql = "INSERT INTO l_languages_pr VALUES (?,?)"; rs = null; st =
		 * null; try { st = conn.prepareStatement(sql); int i=1; st.setLong(i++,
		 * idi); st.setInt(i++, Integer.parseInt(prlang[1]));
		 * st.executeUpdate(); return project; } catch (SQLException e) {
		 * e.printStackTrace(); } finally { try { if (rs != null) rs.close(); if
		 * (st != null) st.close();
		 * ConnectionManager.getConnectorPool().releaseConnection(conn); } catch
		 * (SQLException ex) { } }
		 */

		return null;
	}

	/**
	 * Delete Project
	 */
	public void deleteProject(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from Projects where name=?";
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
		} finally {
			try {
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
	}

	/**
	 * Find Project by id
	 * 
	 */
	public Project findProjectById(long idProject) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where id=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(rs.getInt(2));
				proj.setName(rs.getString(3));
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				// proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				// proj.setTechnologyForOne(rs.getString(11));
				// proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by idOwner
	 */
	public Project findProjectByidOwner(int idOwner) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where id_owner=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(rs.getInt(2));
				proj.setName(rs.getString(3));
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				// proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				// proj.setTechnologyForOne(rs.getString(11));
				// proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by name
	 */
	public Project findProjectByName(String name) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where name=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(rs.getInt(2));
				proj.setName(rs.getString(3));
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				// proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				// proj.setTechnologyForOne(rs.getString(11));
				// proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by Description
	 */
	public Project findProjectByDescription(String Description) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where description=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(rs.getInt(2));
				proj.setName(rs.getString(3));
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				// proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				// proj.setTechnologyForOne(rs.getString(11));
				// proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by DateOfCreation
	 */
	public Project findProjectByDateOfCreation(Date DateOfCreation) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where date_of_creation=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(rs.getInt(2));
				proj.setName(rs.getString(3));
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				// proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				// proj.setTechnologyForOne(rs.getString(11));
				// proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by DateOfClosing
	 */
	public Project findProjectByDateOfClosing(Date DateOfClosing) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where date_of_closing=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(rs.getInt(2));
				proj.setName(rs.getString(3));
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				// proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				// proj.setTechnologyForOne(rs.getString(11));
				// proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by Version
	 */
	public Project findProjectByVersion(int Version) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where version=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(rs.getInt(2));
				proj.setName(rs.getString(3));
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				// proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				// proj.setTechnologyForOne(rs.getString(11));
				// proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by License
	 */
	public Project findProjectByLicense(String License) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where license=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(rs.getInt(2));
				proj.setName(rs.getString(3));
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				// proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				// proj.setTechnologyForOne(rs.getString(11));
				// proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by StageOfDevelopment
	 */
	public Project findProjectByStageOfDevelopment(String StageOfDevelopment) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where stage_of_development=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setUser(rs.getInt(2));
				proj.setName(rs.getString(3));
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				// proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				// proj.setTechnologyForOne(rs.getString(11));
				// proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find all Projects
	 */
	public List<Project> findAllProjects() {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			List<Project> proj = new ArrayList<Project>();
			while (rs.next()) {
				Project tempproj = new Project();
				tempproj.setIdProject(rs.getLong(1));
				tempproj.setUser(rs.getInt(2));
				tempproj.setName(rs.getString(3));
				tempproj.setDescription(rs.getString(4));
				tempproj.setDateOfCreation(rs.getDate(5));
				tempproj.setDateOfClosing(rs.getDate(6));
				// tempproj.setCategoryForOne(rs.getString(7));
				tempproj.setVersion(rs.getInt(8));
				tempproj.setLicense(rs.getString(9));
				tempproj.setStageOfDevelopment(rs.getString(10));
				// tempproj.setTechnologyForOne(rs.getString(11));
				// tempproj.setLanguagesForOne(rs.getString(12));
				proj.add(tempproj);
			}
			return proj;
		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return null;
	}
}
