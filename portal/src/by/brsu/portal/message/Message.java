package by.brsu.portal.message;

import java.sql.Date;
//import java.util.*;

//import by.brsu.portal.user.User;

public class Message {
	private long id;
	private String title;
	private String text;
	private Date date;
	private long idUserTo;
	private long idUserFrom;	
	private int previous;
	private int readed;
	private int priority;
	
	/**
	 * 
	 */
	public Message() {
		super();
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
	public Message(String title, String text,
			Date date,long idUserTo, long idUserFrom, int previous, int readed, int priority) {
		super();
		this.title = title;
		this.text = text;
		this.date = date;
		this.idUserTo = idUserTo;
		this.idUserFrom = idUserFrom;
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
	public long getIdUserFrom() {
		return idUserFrom;
	}
	/**
	 * @param user the user to set
	 */
	public void setIdUserFrom(long idUserFrom) {
		this.idUserFrom = idUserFrom;
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
	public void setIdUserTo(long idUserTo) {
		this.idUserTo = idUserTo;
	}
	/**
	 * @return the idToUser
	 */
	public long getIdUserTo() {
		return idUserTo;
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
		result = prime * result + (int) (idUserTo ^ (idUserTo >>> 32));
		result = prime * result + (int) (idUserFrom ^ (idUserFrom >>> 32));		
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
		if (idUserTo != other.idUserTo)
			return false;
		if (idUserFrom != other.idUserFrom)
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
		return "Message [date=" + date + ", idToUser=" + idUserTo + ", idUserFrom="
				+ idUserFrom + ", previous=" + previous + ", priority="
				+ priority + ", readed=" + readed + ", text=" + text
				+ ", title=" + title + "]";
	}	
}
