/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.news;

import java.util.*;

import by.brsu.portal.user.User;

/**
 * @author Aliaksei Ryzhkou
 * @version 20110712
 */
public class News {

	private long id_news;
	private String title;
	private String text;
	private Date date;
	private Category category; // Stub
	private User author; // Stub

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "News [title=" + title + "]";
	}

	private String important; // Stub

	/**
	 * @return the id_news
	 */
	public long getId_news() {
		return id_news;
	}

	/**
	 * @param id_news
	 *            the id_news to set
	 */
	public void setId_news(long id_news) {
		this.id_news = id_news;
	}

	/**
	 * @param id_news
	 * @param title
	 * @param text
	 * @param category
	 * @param author
	 * @param important
	 */
	public News(long id_news, String title, String text, Category category, User author, String important) {
		//super();
		this.id_news = id_news;
		this.title = title;
		this.text = text;
		this.date = new Date();
		this.category = category;
		this.author = author;
		this.important = important;
	}

	/**
	 * 
	 */
	public News() 
	{
		//super();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the important
	 */
	public String getImportant() {
		return important;
	}

	/**
	 * @param important
	 *            the important to set
	 */
	public void setImportant(String important) {
		this.important = important;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}

}