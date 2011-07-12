/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.Education;

/**
 * @author Roman Ulezlo
 * 
 */
public class Type_edu {
	private long id_type_edu;
	private String name;

	/**
	 * @param id_type_edu
	 * @param name
	 */
	public Type_edu(long id_type_edu, String name) {
		super();
		this.id_type_edu = id_type_edu;
		this.name = name;
	}

	/**
	 * @return the id_type_edu
	 */
	public long getId_type_edu() {
		return id_type_edu;
	}

	/**
	 * @param id_type_edu
	 *            the id_type_edu to set
	 */
	public void setId_type_edu(long id_type_edu) {
		this.id_type_edu = id_type_edu;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_type_edu ^ (id_type_edu >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Type_edu other = (Type_edu) obj;
		if (id_type_edu != other.id_type_edu)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Type_edu [id_type_edu=" + id_type_edu + ", name=" + name + "]";
	}

}
