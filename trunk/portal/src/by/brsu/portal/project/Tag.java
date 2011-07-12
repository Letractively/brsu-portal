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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_tag ^ (id_tag >>> 32));
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
		Tag other = (Tag) obj;
		if (id_tag != other.id_tag)
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tag [id_tag=" + id_tag + ", tag=" + tag + "]";
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
