/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.cv;

/**
 * @author Hraznykh_Pavel
 *
 */
public class L_languages_us {

	private long id_user;
	private long id_language;
	/**
	 * @param id_user
	 * @param id_language
	 */
	public L_languages_us(long id_user, long id_language) {
		super();
		this.id_user = id_user;
		this.id_language = id_language;
	}
	/**
	 * @return the id_user
	 */
	public long getId_user() {
		return id_user;
	}
	/**
	 * @param id_user the id_user to set
	 */
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	/**
	 * @return the id_language
	 */
	public long getId_language() {
		return id_language;
	}
	/**
	 * @param id_language the id_language to set
	 */
	public void setId_language(long id_language) {
		this.id_language = id_language;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_language ^ (id_language >>> 32));
		result = prime * result + (int) (id_user ^ (id_user >>> 32));
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
		L_languages_us other = (L_languages_us) obj;
		if (id_language != other.id_language)
			return false;
		if (id_user != other.id_user)
			return false;
		return true;
	}
	
	
	
}
