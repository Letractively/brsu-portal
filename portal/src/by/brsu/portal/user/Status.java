/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

/**
 * @author Hraznykh_Pavel
 *
 */
public class Status {

	private long id_stat;
	private String name;
	
	/**
	 * @param id_stat
	 * @param name
	 */
	public Status(long id_stat, String name) {
		super();
		this.id_stat = id_stat;
		this.name = name;
	}

	/**
	 * @return the id_stat
	 */
	public long getId_stat() {
		return id_stat;
	}

	/**
	 * @param id_stat the id_stat to set
	 */
	public void setId_stat(long id_stat) {
		this.id_stat = id_stat;
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
		result = prime * result + (int) (id_stat ^ (id_stat >>> 32));
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
		if (id_stat != other.id_stat)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

	
}
