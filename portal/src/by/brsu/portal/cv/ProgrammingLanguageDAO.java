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
 * @author Artur Smaliuk, Roman Ulezlo
 * 
 */
public class ProgrammingLanguageDAO implements IProgrammingLanguageDAO {
	private Connection conn = null;

	public ProgrammingLanguage findProgrammingLanguageById(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select * from language where id_language=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
				programmingLanguage.setIdLanguage(rs.getLong(1));
				programmingLanguage.setName(rs.getString(2));
				return programmingLanguage;
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

	public List<ProgrammingLanguage> findAllLanguages() {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "select * from language";
		ResultSet rs = null;
		PreparedStatement st = null;
		List<ProgrammingLanguage> proglang = new ArrayList<ProgrammingLanguage>();
		try {
			st = conn.prepareStatement("");
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ProgrammingLanguage tempproglang = new ProgrammingLanguage();
				tempproglang.setIdLanguage(rs.getLong(1));
				tempproglang.setName(rs.getString(2));
				proglang.add(tempproglang);
			}
		} catch (SQLException e) {
			/*
			 * throw new PortalTechnicalException(
			 * "Error of performance of inquiry!");
			 */
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
				/*
				 * throw new PortalTechnicalException(
				 * "Error closing object ResultSet or PreparedStatement!");
				 */
			}
		}
		return proglang;
	}
	public List<ProgrammingLanguage> findProgrammingLanguagesByProjectId(long id) {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select language.id_language, name from language inner join l_languages_pr on l_languages_pr.id_language=language.id_language where l_languages_pr.id_project=?";
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			List<ProgrammingLanguage> languages = new ArrayList<ProgrammingLanguage>();
			while (rs.next()) {
				ProgrammingLanguage language = new ProgrammingLanguage();
				language.setIdLanguage(rs.getLong(1));
				language.setName(rs.getString(2));
				languages.add(language);
			}
			return languages;
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
