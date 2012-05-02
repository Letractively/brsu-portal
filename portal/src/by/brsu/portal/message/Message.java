package by.brsu.portal.message;

import java.sql.Date;

import by.brsu.portal.user.User;
//import java.util.*;

//import by.brsu.portal.user.User;

public class Message {
	private long id;
	private String title;
	private String text;
	private Date date;
	private User UserTo;
	private User UserFrom;	
	private int previous;
	private int readed;
	private int priority;
	
	/**
	 * 
	 */
	public Message() {
		super();
	}

	public Message(Message msg) {
		this.id=msg.id;
		this.title=msg.title;
		this.text=msg.text;
		this.date=msg.date;
		this.UserTo=msg.UserTo;
		this.UserFrom=msg.UserFrom;
		this.previous=msg.previous;
		this.readed=msg.readed;
		this.priority=msg.priority;
	}
	/**
	 * @param id
	 * @param title
	 * @param text
	 * @param date
	 * @param read
	 * @param sent
	 * @param author
	 */
	public Message(long idMessage,String title, String text,
			Date date,User UserTo, User UserFrom, int previous, int readed, int priority) {
		super();
		this.id=idMessage;
		this.title = title;
		this.text = text;
		this.date = date;
		this.UserTo = UserTo;
		this.UserFrom = UserFrom;
		this.previous = previous;
		this.readed = readed;
		this.priority = priority;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
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
	 * @param text the text to set
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
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * @return the user
	 */
	public User getUserFrom() {
		return UserFrom;
	}
	/**
	 * @param user the user to set
	 */
	public void setUserFrom(User UserFrom) {
		this.UserFrom = UserFrom;
	}
	/**
	 * @return the previous
	 */
	public int getPrevious() {
		return previous;
	}
	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(int previous) {
		this.previous = previous;
	}
	/**
	 * @return the readed
	 */
	public int getReaded() {
		return readed;
	}
	/**
	 * @param readed the readed to set
	 */
	public void setReaded(int readed) {
		this.readed = readed;
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @param idToUser the idToUser to set
	 */
	public void setUserTo(User UserTo) {
		this.UserTo = UserTo;
	}
	/**
	 * @return the idToUser
	 */
	public User getUserTo() {
		return UserTo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (UserTo.getId() ^ (UserTo.getId() >>> 32));
		result = prime * result + (int) (UserFrom.getId() ^ (UserFrom.getId() >>> 32));		
		result = prime * result + previous;
		result = prime * result + priority;
		result = prime * result + readed;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Message other = (Message) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (UserTo != other.UserTo)
			return false;
		if (UserFrom != other.UserFrom)
			return false;		
		if (previous != other.previous)
			return false;
		if (priority != other.priority)
			return false;
		if (readed != other.readed)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [idMessage="+id+", date=" + date + ", idToUser=" + UserTo.getId() + ", idUserFrom="
				+ UserFrom.getId() + ", previous=" + previous + ", priority="
				+ priority + ", readed=" + readed + ", text=" + text
				+ ", title=" + title + "]";
	}	
}
