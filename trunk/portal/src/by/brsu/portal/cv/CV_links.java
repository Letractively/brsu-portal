/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

/**
 * @author Oleg Panasyuk
 *
 */
public class CV_links {
	private User user;
	private long id_link;
	private String link;
	/**
	 * 
	 */
	public CV_links() {
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId_link() {
		return id_link;
	}
	public void setId_link(long id_link) {
		this.id_link = id_link;
	}
	
	public String getLink() {
		return link;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_link ^ (id_link >>> 32));
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CV_links other = (CV_links) obj;
		if (id_link != other.id_link)
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		return true;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "CV_links [toString()=" + super.toString() + "]";
	}
}
