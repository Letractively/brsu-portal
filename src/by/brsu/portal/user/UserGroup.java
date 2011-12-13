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
	
	private long idUserGroup;
	private String name;
	/**
	 * @param idUserGroup
	 * @param name
	 */
	public UserGroup(long idUserGroup, String name) {
		super();
		this.idUserGroup = idUserGroup;
		this.name = name;
	}
	/**
	 * @return the idUserGroup
	 */
	public long getIdUserGroup() {
		return idUserGroup;
	}
	/**
	 * @param idUserGroup the idUserGroup to set
	 */
	public void setIdUserGroup(long idUserGroup) {
		this.idUserGroup = idUserGroup;
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
		result = prime * result + (int) (idUserGroup ^ (idUserGroup >>> 32));
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
		if (idUserGroup != other.idUserGroup)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}
