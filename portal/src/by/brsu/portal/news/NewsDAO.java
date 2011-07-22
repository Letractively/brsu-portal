package by.brsu.portal.news;

import java.sql.*;

import by.brsu.portal.ConnectionManager;
import by.brsu.portal.user.*;

public class NewsDAO {
	private Connection conn;

	public News createNews(String title, String msg, Category category,
			User user) throws SQLException {

		Statement stat = null;
		ResultSet rs = null;
		try {
			Date date = new Date(System.currentTimeMillis());
			PreparedStatement set = conn
					.prepareStatement("INSERT INTO news VALUES(null,?,?,?,?,?,?)");
			set.setString(1, title);
			set.setString(2, msg);
			set.setDate(3, date);
			set.setInt(4, category.getId());
			set.setString(5, ""); // Stub 22.07.2011
			set.setLong(6, user.getId());
			set.executeUpdate();
			stat = conn.createStatement();
			rs = stat
					.executeQuery("SELECT id FROM status where title='" + title
							+ " AND text=" + msg + "' AND USER=" + user.getId());
			if (rs.next()) {
				News n = new News();
				n.setTitle(rs.getString(1));
				n.setText(rs.getString(2));
				n.setDate(rs.getDate(3));
				n.setCategory(category);
				n.setDate(date);
				n.setAuthor(user);
				return n;
			}

		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	/**
	 * Delete database news
	 */
	public void delTable() throws SQLException {
		String query = "DROP TABLE news";
		Statement stat = null;

		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
			}
		}
	}
	/**
	 * Add table to database from news
	 */
	public void addTable() throws SQLException {
		String query = "create table news (id_news int not null auto_increment primary key,title varchar(100) not null,text text not null,created_date date,id_category int not null,important varchar(30) not null default '',id_author int not null,foreign key (id_category) references categories_pr(id_category),foreign key (id_author) references users(id_user));";
		Statement stat = null;
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
			}
		}
	}
	
	/**
	 * @param conn
	 */
	public NewsDAO() {
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
