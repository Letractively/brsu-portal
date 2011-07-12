/**
 * BrSU Projects Portal
 */
package by.brsu.portal.project;

import java.util.*;

import by.brsu.portal.user.*;

/**
 * @author Aliaksei Ryzhkou
 * @version 20110712
 */

public class Comment {
	/**
	 * @param id_comment
	 * @param user
	 * @param project
	 * @param date
	 * @param text
	 */
	public Comment(long id_comment, User user, Project project, String text) {
		//super();
		this.id_comment = id_comment;
		this.user = user;
		this.project = project;
		this.date = new Date();
		this.text = text;
	}
	/**
	 * 
	 */
	public Comment() {
		//super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [text=" + text + "]";
	}
	/**
	 * @return the id_comment
	 */
	public long getId_comment() {
		return id_comment;
	}
	/**
	 * @param id_comment the id_comment to set
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
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
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
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	private long id_comment;
	private User user;
	private Project project;
	private Date date;
	private String text;
}
