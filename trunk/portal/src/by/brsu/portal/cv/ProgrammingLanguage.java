/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

/**
 * @author Hraznykh_Pavel
 *
 */
public class ProgrammingLanguage {

	private long idUser;
	private long idLanguage;
	private String name;
	/**
	 * @param idUser
	 * @param idLanguage
	 * @param name
	 */
	public ProgrammingLanguage(long idUser, long idLanguage, String name) {
		super();
		this.idUser = idUser;
		this.idLanguage = idLanguage;
		this.name = name;
	}
	/**
	 * @return the idUser
	 */
	public long getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	/**
	 * @return the idLanguage
	 */
	public long getIdLanguage() {
		return idLanguage;
	}
	/**
	 * @param idLanguage the idLanguage to set
	 */
	public void setIdLanguage(long idLanguage) {
		this.idLanguage = idLanguage;
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
		result = prime * result + (int) (idLanguage ^ (idLanguage >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
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
		ProgrammingLanguage other = (ProgrammingLanguage) obj;
		if (idLanguage != other.idLanguage)
			return false;
		if (idUser != other.idUser)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
