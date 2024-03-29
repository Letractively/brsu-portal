/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

package by.brsu.portal.news;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import by.brsu.portal.ConnectionManager;
import by.brsu.portal.user.*;

/**
 * @author Aliaksei Ryzhkou
 * @version 20110722
 */
public class NewsDAO {
	private Connection conn;
	private static final Logger log = Logger.getLogger(NewsDAO.class);

	/**
	 * Insert date in database news
	 * 
	 * @throws IOException
	 */
	public News createNews(String title, String msg, Category category,
			User user) throws SQLException, IOException {

		Statement stat = null;
		ResultSet rs = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
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
			rs = stat.executeQuery("SELECT id_news FROM news where title='"
					+ title + "' AND text='" + msg + "' AND id_author="
					+ user.getId());
			if (rs.next()) {
				News n = new News();
				n.setId(rs.getInt(1));
				n.setTitle(title);
				n.setText(msg);
				;
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
				log.error(e);
			}

		}
		return null;
	}

	/**
	 * Delete database news
	 * 
	 * @throws IOException
	 */
	public Boolean delTable() throws SQLException, IOException {
		String query = "DROP TABLE news";
		Statement stat = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			log.error(e);
			return false;
		} finally {
			try {
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
			}
		}
	}

	public Boolean delNews(News news) throws SQLException, IOException {
		String query = "DELETE FROM news WHERE id_news=?";
		String query2 = "DELETE FROM Comments_news WHERE id_news=?";
		Statement stat = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);

		try {
			PreparedStatement set = conn.prepareStatement(query);
			set.setLong(1, news.getId());
			set.executeUpdate();
			PreparedStatement set2 = conn.prepareStatement(query2);
			set2.setLong(1, news.getId());
			set2.executeUpdate();
			return true;
		} catch (SQLException e) {
			log.error(e);
			return false;
		} finally {
			try {
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				return false;
			}
		}
	}

	/**
	 * Add table to database from news
	 * 
	 * @throws IOException
	 */
	public void addTable() throws SQLException, IOException {
		String query = "create table news (id_news int not null auto_increment primary key,title varchar(100) not null,text text not null,created_date date,id_category int not null,important varchar(30) not null default '',id_author int not null,foreign key (id_category) references categories_pr(id_category),foreign key (id_author) references users(id_user));";
		Statement stat = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU-Log.txt", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			stat = conn.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			log.error(e);
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
	 * 
	 * @throws IOException
	 */
	public News updateNews(long id, String title, String msg,
			Category category, User user) throws SQLException, IOException {
		Statement stat = null;
		ResultSet rs = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			Date date = new Date(System.currentTimeMillis());
			PreparedStatement set = conn
					.prepareStatement("UPDATE news SET title=?,text=?,created_date=?,id_category=?,important=?,id_author=? WHERE id_news=? ");
			set.setString(1, title);
			set.setString(2, msg);
			set.setDate(3, date);
			set.setInt(4, category.getId());
			set.setString(5, ""); // Stub 22.07.2011
			set.setLong(6, user.getId());
			set.setLong(7, id);
			set.executeUpdate();
			News news = new News(id, title, msg, category, user, "");
			return news;

		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
			} catch (SQLException e) {
				log.error(e);
			}

		}
		return null;
	}

	/**
	 * @param conn
	 * @throws IOException
	 */
	public NewsDAO() {
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
		} catch (Exception e) {
		}
	}

	/**
	 * Refresh this connection from datebase
	 * 
	 * @throws IOException
	 */
	public void ReFreshConnection() throws IOException {
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			this.conn = ConnectionManager.getConnectorPool().getConnection();
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Get List News from datebase
	 * 
	 * @throws IOException
	 */
	public List<News> readNews() throws IOException {
		Statement stat = null;
		ResultSet rs = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		List<News> news = new ArrayList<News>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery("SELECT * FROM news");
			while (rs.next()) {
				News n = new News();
				// Stub 27.07.2011 Begin
				Category category = new Category();
				category.setId(1);
				User user = new User();
				user.setId(1);
				user.setName("root");
				// Stub 27.07.2011 End
				n.setId(rs.getLong(1));
				n.setTitle(rs.getString(2));
				n.setText(rs.getString(3));
				n.setDate(rs.getDate(4));
				n.setCategory(category);
				n.setAuthor(user);
				news.add(n);
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
				ConnectionManager.getConnectorPool().releaseConnection(conn);
			} catch (SQLException ex) {
			}
		}
		return news;
	}

	/**
	 * Get List News from datebase for a given page
	 */
	public List<News> readNewsByPage(int page, int i) {
		// Statement stat = null;
		// ResultSet rs = null;
		List<News> news = new ArrayList<News>();
		return news;
	}

	public News findNewsById() {
		News news = new News();
		return news;
	}
}
