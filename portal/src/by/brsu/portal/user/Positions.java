/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

/**
 * @author јртур и Ёлла
 *
 */
public class Positions 
{
	private int id_pos;
	private char name;
	
	/**
	 * @return the id_pos
	 */
	public int getId_pos() 
	{
		return id_pos;
	}
	
	/**
	 * @param set id_pos
	 */
	public void setId_pos(int id_pos) 
	{
		this.id_pos = id_pos;
	}
	
	/**
	 * @return the name
	 */
	public char getName() 
	{
		return name;
	}
	
	/**
	 * @param set name
	 */
	public void setName(char name)
	{
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id_pos;
		result = prime * result + name;
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
		Positions other = (Positions) obj;
		if (id_pos != other.id_pos)
			return false;
		if (name != other.name)
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Positions [id_pos=" + id_pos + ", name=" + name + "]";
	}
	

}
