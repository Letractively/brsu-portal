/**
 * BrSU Projects Portal
 */
package by.brsu.portal.project;

import java.util.*;

import by.brsu.portal.user.*;

/**
 * @author Aliaksei Ryzhkou
 * @version 20110713
 */

public class CommentProject {
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (id_comment ^ (id_comment >>> 32));
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentProject other = (CommentProject) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id_comment != other.id_comment)
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	/**
	 * @param id_comment
	 * @param user
	 * @param project
	 * @param date
	 * @param text
	 */
	public CommentProject(long id_comment, User user, Project project, String text) {
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
	public CommentProject() {
		//super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comments_pr [text=" + text + "]";
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
