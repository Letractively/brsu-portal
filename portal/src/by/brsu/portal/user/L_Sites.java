/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

/**
 * @author Hraznykh_Pavel
 *
 */
public class L_Sites {
	
	private long id_site;
	private long id_user;
	private String site;
	
	
	/**
	 * @param id_site
	 * @param id_user
	 * @param site
	 */
	public L_Sites(long id_site, long id_user, String site) {
		super();
		this.id_site = id_site;
		this.id_user = id_user;
		this.site = site;
	}
	/**
	 * @return the id_site
	 */
	public long getId_site() {
		return id_site;
	}
	/**
	 * @param id_site the id_site to set
	 */
	public void setId_site(long id_site) {
		this.id_site = id_site;
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
	 * @return the site
	 */
	public String getSite() {
		return site;
	}
	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_site ^ (id_site >>> 32));
		result = prime * result + (int) (id_user ^ (id_user >>> 32));
		result = prime * result + ((site == null) ? 0 : site.hashCode());
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
		L_Sites other = (L_Sites) obj;
		if (id_site != other.id_site)
			return false;
		if (id_user != other.id_user)
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		return true;
	}
	

}
