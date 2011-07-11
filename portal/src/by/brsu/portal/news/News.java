package by.brsu.portal.news;

import java.util.*;

/**
 * @author Aliaksei Ryzhkou
 * @version 20110711
 */
public class News 
{	
	public News(int id_news, String title, String text, int id_category, String important, int id_author) 
	{
		super();
		this.id_news = id_news;
		this.title = title;
		this.text = text;
		this.date = new Date();
		this.id_category = id_category;
		this.important = important;
		this.id_author = id_author;
	}
	private int id_news;
	private String title;
	private String text;
	private Date date;
	private int id_category;
	private String important;
	private int id_author;
	
	public int getId_news() 
	{
		return id_news;
	}
	public void setId_news(int id_news) 
	{
		this.id_news = id_news;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public String getText() 
	{
		return text;
	}
	public void setText(String text) 
	{
		this.text = text;
	}
	public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}
	public int getId_category() 
	{
		return id_category;
	}
	public void setId_category(int id_category) 
	{
		this.id_category = id_category;
	}
	public String getImportant() 
	{
		return important;
	}
	public void setImportant(String important) 
	{
		this.important = important;
	}
	public int getId_author() 
	{
		return id_author;
	}
	public void setId_author(int id_author) 
	{
		this.id_author = id_author;
	}
	
	@Override
	public String toString() 
	{
		return "News [title=" + title + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id_author;
		result = prime * result + id_category;
		result = prime * result + id_news;
		result = prime * result + ((important == null) ? 0 : important.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (date == null) 
		{
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id_author != other.id_author)
			return false;
		if (id_category != other.id_category)
			return false;
		if (id_news != other.id_news)
			return false;
		if (important == null) 
		{
			if (other.important != null)
				return false;
		} 
		else if (!important.equals(other.important))
			return false;
		if (text == null) 
		{
			if (other.text != null)
				return false;
		} 
		else if (!text.equals(other.text))
			return false;
		if (title == null) 
		{
			if (other.title != null)
				return false;
		} 
		else if (!title.equals(other.title))
			return false;
		return true;
	}
}
/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */