/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.news;

import java.util.*;

import by.brsu.portal.user.*;

/**
 * @author Aliaksei Ryzhkou
 * @version 20110713
 */
public class CommentNews {
	private long id_comment;

	/**
	 * @param id_comment
	 * @param user
	 * @param news
	 * @param date
	 * @param text
	 */
	public CommentNews(long id_comment, User user, News news, String text) {
		// super();
		this.id_comment = id_comment;
		this.user = user;
		this.news = news;
		this.date = new Date();
		this.text = text;
	}

	/**
	 * 
	 */
	public CommentNews() {
		// super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [text=" + text + "]";
	}

	private User user;
	private News news;
	private Date date;
	private String text;

	/**
	 * @return the id_comment
	 */
	public long getId_comment() {
		return id_comment;
	}

	/**
	 * @param id_comment
	 *            the id_comment to set
	 */
	public void setId_comment(long id_comment) {
		this.id_comment = id_comment;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the news
	 */
	public News getNews() {
		return news;
	}

	/**
	 * @param news
	 *            the news to set
	 */
	public void setNews(News news) {
		this.news = news;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
}
