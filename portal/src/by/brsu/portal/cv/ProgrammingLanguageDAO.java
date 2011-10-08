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
 * @author Artur Smaliuk
 *
 */
public class ProgrammingLanguageDAO implements IProgrammingLanguageDAO{
	private Connection conn = null;
	public List<ProgrammingLanguage> findAllLanguages()
			/*throws PortalTechnicalException*/ {
		conn = ConnectionManager.getConnectorPool().getConnection();
		String sql = "Select * from language";
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
			/*throw new PortalTechnicalException(
					"Error of performance of inquiry!");*/
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
				/*throw new PortalTechnicalException(
						"Error closing object ResultSet or PreparedStatement!");*/
			}
		}
		return proglang;
	}
}
