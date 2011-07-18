/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

/**
 * @author Roman Ulezlo
 * 
 */
public class Technology {
	private long id_tech;
	private String name;

	/**
	 * @param id_tech
	 * @param name
	 */
	public Technology(long id_tech, String name) {
		super();
		this.id_tech = id_tech;
		this.name = name;
	}

	/**
	 * @return the id_tech
	 */
	public long getId() {
		return id_tech;
	}

	/**
	 * @param id_tech
	 *            the id_tech to set
	 */
	public void setId(long id_tech) {
		this.id_tech = id_tech;
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
		result = prime * result + (int) (id_tech ^ (id_tech >>> 32));
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
		Technology other = (Technology) obj;
		if (id_tech != other.id_tech)
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
		return "Technologies [id_tech=" + id_tech + ", name=" + name + "]";
	}

}
