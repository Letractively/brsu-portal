/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.brsu.portal.ConnectionManager;

/**
 * @author Roman Ulezlo
 * 
 */
public class LinkDAO {
	private Connection connection = null;

	public Link createLink(Link link) {
		connection = ConnectionManager.getConnectorPool().getConnection();
		String sql = "insert into links values (null,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, link.getName());
			preparedStatement.setLong(2, link.getProject().getIdProject());
			preparedStatement.executeUpdate();
			sql = "select last_insert_id()";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				link.setId(resultSet.getLong(1));
			}
			return link;
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
}
