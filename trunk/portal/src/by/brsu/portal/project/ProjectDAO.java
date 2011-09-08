/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

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
 * @author Artur Smaliuk
 *
 */
public class ProjectDAO 
{
	private Connection conn = null;

	/**
	 * Add project
	 * 
	 */
	public Project createProject(int idOwner, String name, String description, Date dateOfCreation, Date dateOfClosing, 
			ProjectCategory category, int version, String license, 
			String stageOfDevelopment, List<Technology> technology, List<ProgrammingLanguage> languages) 
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into Projects values (?,?,?,?,?,?,?,?,?,?,?,?)";
		ResultSet rs = null;
		PreparedStatement st = null;
		try 
		{
			st = conn.prepareStatement(sql);
			st.setString(2, name);
			st.executeUpdate();
			st = conn.prepareStatement("");
			rs = st.executeQuery("Select id from Projects where name=?");
			if (rs.next()) 
			{
				Project proj = new Project();				
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(idOwner);
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
		} catch (SQLException e) 
		{
		} 
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}

	/**
	 * Delete Project
	 */
	public void deleteProject(String name) 
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "delete from Projects where name=?";
		Statement st = null;
		try 
		{
			st = conn.createStatement();
			st.executeUpdate(sql);
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
	}

	/**
	 * Find Project by id
	 * 
	 */
	public Project findProjectById(long idProject) 
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where id=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(rs.getInt(2));
				proj.setName(rs.getString(3));				
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				proj.setTechnologyForOne(rs.getString(11));
				proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} 
		catch (SQLException e) 
		{
		} 
		finally
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}

	/**
	 * Find Project by idOwner
	 */
	public Project findProjectByidOwner(int idOwner)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where id_owner=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(rs.getInt(2));
				proj.setName(rs.getString(3));				
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				proj.setTechnologyForOne(rs.getString(11));
				proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
	
	/**
	 * Find Project by name
	 */
	public Project findProjectByName(String name)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where name=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(rs.getInt(2));
				proj.setName(rs.getString(3));				
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				proj.setTechnologyForOne(rs.getString(11));
				proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
	
	/**
	 * Find Project by Description
	 */
	public Project findProjectByDescription(String Description)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where description=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(rs.getInt(2));
				proj.setName(rs.getString(3));				
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				proj.setTechnologyForOne(rs.getString(11));
				proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
	
	/**
	 * Find Project by DateOfCreation
	 */
	public Project findProjectByDateOfCreation(Date DateOfCreation)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where date_of_creation=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(rs.getInt(2));
				proj.setName(rs.getString(3));				
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				proj.setTechnologyForOne(rs.getString(11));
				proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
	
	/**
	 * Find Project by DateOfClosing
	 */
	public Project findProjectByDateOfClosing(Date DateOfClosing)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where date_of_closing=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(rs.getInt(2));
				proj.setName(rs.getString(3));				
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				proj.setTechnologyForOne(rs.getString(11));
				proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
	
	/**
	 * Find Project by Version
	 */
	public Project findProjectByVersion(int Version)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where version=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(rs.getInt(2));
				proj.setName(rs.getString(3));				
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				proj.setTechnologyForOne(rs.getString(11));
				proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
	
	/**
	 * Find Project by License
	 */
	public Project findProjectByLicense(String License)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where license=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(rs.getInt(2));
				proj.setName(rs.getString(3));				
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				proj.setTechnologyForOne(rs.getString(11));
				proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
	
	/**
	 * Find Project by StageOfDevelopment
	 */
	public Project findProjectByStageOfDevelopment(String StageOfDevelopment)
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects where stage_of_development=?";
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				Project proj = new Project();
				proj.setIdProject(rs.getLong(1));
				proj.setIdOwner(rs.getInt(2));
				proj.setName(rs.getString(3));				
				proj.setDescription(rs.getString(4));
				proj.setDateOfCreation(rs.getDate(5));
				proj.setDateOfClosing(rs.getDate(6));
				proj.setCategoryForOne(rs.getString(7));
				proj.setVersion(rs.getInt(8));
				proj.setLicense(rs.getString(9));
				proj.setStageOfDevelopment(rs.getString(10));
				proj.setTechnologyForOne(rs.getString(11));
				proj.setLanguagesForOne(rs.getString(12));
				return proj;
			}
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
	
	/**
	 * Find all Projects
	 */
	public List<Project> findAllProjects() 
	{
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from Projects";
		ResultSet rs = null;
		PreparedStatement st = null;
		try 
		{
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			List<Project> proj = new ArrayList<Project>();
			while (rs.next()) 
			{
				Project tempproj = new Project();
				tempproj.setIdProject(rs.getLong(1));
				tempproj.setIdOwner(rs.getInt(2));
				tempproj.setName(rs.getString(3));				
				tempproj.setDescription(rs.getString(4));
				tempproj.setDateOfCreation(rs.getDate(5));
				tempproj.setDateOfClosing(rs.getDate(6));
				tempproj.setCategoryForOne(rs.getString(7));
				tempproj.setVersion(rs.getInt(8));
				tempproj.setLicense(rs.getString(9));
				tempproj.setStageOfDevelopment(rs.getString(10));
				tempproj.setTechnologyForOne(rs.getString(11));
				tempproj.setLanguagesForOne(rs.getString(12));
				proj.add(tempproj);
			}
			return proj;
		} 
		catch (SQLException e) 
		{
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException ex) 
			{
			}
		}
		return null;
	}
}
