/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

/**
 * @author Hraznykh_Pavel
 *
 */
public class  Status {

	private long idStat;
	private String name;
	
		
	/**
	 * @param idStat
	 * @param name
	 */
	public  Status(long idStat, String name) {
		super();
		this.idStat = idStat;
		this.name = name;
	}
	/**
	 * @return the idStat
	 */
	public long getIdStat() {
		return idStat;
	}
	/**
	 * @param idStat the idStat to set
	 */
	public void setIdStat(long idStat) {
		this.idStat = idStat;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idStat ^ (idStat >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Status other = (Status) obj;
		if (idStat != other.idStat)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

	
}
