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
import by.brsu.portal.ConnectionManager;
import by.brsu.portal.cv.ProgrammingLanguage;
import by.brsu.portal.cv.Technology;

/**
 * @author Artur Smaliuk, Roman Ulezlo
 * 
 */
public class ProjectDAO {
	private Connection connection = null;

	/**
	 * Create new project
	 * @param project
	 * @return
	 * @throws IOException
	 */
	public Project createProject(Project project) throws IOException {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into projects values (null,?,?,?,?,null,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, project.getUser());
			preparedStatement.setString(2, project.getName());
			preparedStatement.setString(3, project.getDescription());
			preparedStatement.setDate(4,
					new java.sql.Date(System.currentTimeMillis()));
			// st.setDate(5, (java.sql.Date) project.getDateOfClosing());
			preparedStatement.setLong(5, project.getCategory().getId());
			preparedStatement.setLong(6, project.getVersion());
			preparedStatement.setString(7, project.getLicense());
			preparedStatement.setString(8, project.getStageOfDevelopment());
			preparedStatement.executeUpdate();
			
			//max index is got on from database
			sql = "select last_insert_id()";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				project.setIdProject(resultSet.getLong(1));
			}

			// information about programming languages is saved in database
			for (ProgrammingLanguage programmingLanguage : project
					.getLanguages()) {
				sql = "insert into l_languages_pr values (?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, project.getIdProject());
				preparedStatement.setLong(2,
						programmingLanguage.getIdLanguage());
				preparedStatement.executeUpdate();
			}

			// information about technologies is saved in database
			for (Technology technology : project.getTechnology()) {
				sql = "insert into l_technologies_pr values (?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, project.getIdProject());
				preparedStatement.setLong(2, technology.getId());
				preparedStatement.executeUpdate();
			}
			
			//information about links is saved in database
			LinkDAO linkDAO = new LinkDAO();
			for (Link link : project.getLinks()){
				linkDAO.createLink(link);
			}
			return project;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
		return null;
	}

	/**
	 * Delete Project
	 */
	public void deleteProject(String name) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from Projects where name=?";
		Statement st = null;
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
		} finally {
			try {
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
	}

	/**
	 * Find Project by id
	 * 
	 */
	public Project findProjectById(long idProject) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where id=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
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
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by idOwner
	 */
	public Project findProjectByidOwner(int idOwner) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where id_owner=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
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
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by name
	 */
	public Project findProjectByName(String name) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where name=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
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
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by Description
	 */
	public Project findProjectByDescription(String Description) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where description=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
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
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by DateOfCreation
	 */
	public Project findProjectByDateOfCreation(Date DateOfCreation) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where date_of_creation=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
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
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by DateOfClosing
	 */
	public Project findProjectByDateOfClosing(Date DateOfClosing) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where date_of_closing=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
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
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by Version
	 */
	public Project findProjectByVersion(int Version) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where version=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
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
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by License
	 */
	public Project findProjectByLicense(String License) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where license=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
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
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find Project by StageOfDevelopment
	 */
	public Project findProjectByStageOfDevelopment(String StageOfDevelopment) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where stage_of_development=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
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
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	/**
	 * Find all Projects
	 */
	public List<Project> findAllProjects() {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select * from projects";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Project> projects = new ArrayList<Project>();
			while (resultSet.next()) {
				Project project = new Project();
				project.setIdProject(resultSet.getLong(1));
				project.setUser(resultSet.getInt(2));
				project.setName(resultSet.getString(3));
				project.setDescription(resultSet.getString(4));
				project.setDateOfCreation(resultSet.getDate(5));
				project.setDateOfClosing(resultSet.getDate(6));

				// Information about project category is got from database
				sql = "select * from categories_pr where id_category=?";
				PreparedStatement preparedStatementInner = connection
						.prepareStatement(sql);
				preparedStatementInner.setLong(1, resultSet.getInt(7));
				ResultSet resultSetInner = preparedStatementInner
						.executeQuery();
				ProjectCategory projectCategory = new ProjectCategory();
				if (resultSetInner.next()) {
					projectCategory.setId(resultSetInner.getLong(1));
					projectCategory.setName(resultSetInner.getString(2));
				}
				project.setCategory(projectCategory);
				project.setVersion(resultSet.getInt(8));
				project.setLicense(resultSet.getString(9));
				project.setStageOfDevelopment(resultSet.getString(10));
				// project.setTechnologyForOne(resultSet.getString(11));
				// project.setLanguagesForOne(resultSet.getString(12));
				projects.add(project);
			}
			return projects;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return null;
	}
	
	public void addParticipantInProject(Long idProject, Long idUser, Long idPosition){
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into l_pos values(?,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, idProject);
			preparedStatement.setLong(2, idUser);
			preparedStatement.setLong(3, idPosition);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				ConnectionManager.getConnectorPool().releaseConnection(
						connection);
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
	}
}
