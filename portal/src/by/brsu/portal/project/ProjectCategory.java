/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

/**
 * @author Roman Ulezlo
 * 
 */
public class ProjectCategory {
	private long id_category;
	private String name;

	/**
	 * @param id_category
	 * @param name
	 */
	public ProjectCategory(long id_category, String name) {
		super();
		this.id_category = id_category;
		this.name = name;
	}

	/**
	 * @return the id_category
	 */
	public long getId_category() {
		return id_category;
	}

	/**
	 * @param id_category
	 *            the id_category to set
	 */
	public void setId_category(long id_category) {
		this.id_category = id_category;
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
		result = prime * result + (int) (id_category ^ (id_category >>> 32));
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
		ProjectCategory other = (ProjectCategory) obj;
		if (id_category != other.id_category)
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
		return "Categories_pr [id_category=" + id_category + ", name=" + name
				+ "]";
	}

}
