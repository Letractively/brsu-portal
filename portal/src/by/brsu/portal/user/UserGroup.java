/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

/**
 * @author Hraznykh_Pavel
 *
 */
public class UserGroup {
	
	private long id_user_group;
	private String name;
	/**
	 * @param id_user_group
	 * @param name
	 */
	public UserGroup(long id_user_group, String name) {
		super();
		this.id_user_group = id_user_group;
		this.name = name;
	}
	/**
	 * @return the id_user_group
	 */
	public long getId_user_group() {
		return id_user_group;
	}
	/**
	 * @param id_user_group the id_user_group to set
	 */
	public void setId_user_group(long id_user_group) {
		this.id_user_group = id_user_group;
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
		result = prime * result + (int) (id_user_group ^ (id_user_group >>> 32));
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
		UserGroup other = (UserGroup) obj;
		if (id_user_group != other.id_user_group)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
