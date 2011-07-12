/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

/**
 * @author Oleg Panasyuk
 *
 */
public class Tag {
	private long id_tag;
	private String tag;
	/**
	 * 
	 */
	public Tag(long id_tag, String tag) {
		// TODO Auto-generated constructor stub
		this.id_tag = id_tag;
		this.tag = tag;
	}
	public long getId_tag() {
		return id_tag;
	}
	public void setId_tag(long id_tag) {
		this.id_tag = id_tag;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

}
