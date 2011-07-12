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
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "CV_links [toString()=" + super.toString() + "]";
	}
}
