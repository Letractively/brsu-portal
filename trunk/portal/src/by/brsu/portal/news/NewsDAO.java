/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

package by.brsu.portal.news;

import java.sql.*;

import by.brsu.portal.ConnectionManager;
import by.brsu.portal.user.*;

/**
 * @author Aliaksei Ryzhkou
 * @version 20110722
 */
public class NewsDAO {
	private Connection conn;

	/**
	 * Insert date in database news
	 */
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
			rs = stat.executeQuery("SELECT id FROM news where title='" + title
					+ " AND text=" + msg + "' AND USER=" + user.getId());
			if (rs.next()) {
				News n = new News();
				n.setId(rs.getInt(1));
				n.setTitle(title);
				n.setText(msg);;
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

	public void delNews(News news) throws SQLException {
		String query = "DELETE FROM news WHERE id_news=?";
		String query2 = "DELETE FROM Comments_news WHERE id_news=?";
		Statement stat = null;

		try {
			PreparedStatement set = conn.prepareStatement(query);
			set.setLong(1, news.getId());
			set.executeUpdate();
			set = conn.prepareStatement(query2);
			set.executeUpdate();
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
	 * Update table to database from news
	 */
	public News updateNews(int id, String title, String msg, Category category,
			User user) throws SQLException {

		Statement stat = null;
		ResultSet rs = null;
		try {
			Date date = new Date(System.currentTimeMillis());
			PreparedStatement set = conn
					.prepareStatement("UPDATE news SET title=?,text=?,date=?,id_category=?,important=?,id_author=? WHERE id_news=? ");
			set.setString(1, title);
			set.setString(2, msg);
			set.setDate(3, date);
			set.setInt(4, category.getId());
			set.setString(5, ""); // Stub 22.07.2011
			set.setLong(6, user.getId());
			set.setInt(7, id);
			set.executeUpdate();
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT id FROM news WHERE id_news="
					+ String.valueOf(id));
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
	 * @param conn
	 */
	public NewsDAO() {
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Refresh this connection from datebase
	 */
	private void ReFreshConnection() {
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
