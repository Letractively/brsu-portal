/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

/**
 * @author Oleg Panasyuk
 *
 */
public class Language {
	
	private long id_language;
	private String language;
	/**
	 * 
	 */
	public Language(long id_language, String language) {
		// TODO Auto-generated constructor stub
		this.id_language = id_language;
		this.language = language;
	}
	public long getId_language() {
		return id_language;
	}
	public void setId_language(long id_language) {
		this.id_language = id_language;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_language ^ (id_language >>> 32));
		result = prime * result + ((language == null) ? 0 : language.hashCode());
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
		Language other = (Language) obj;
		if (id_language != other.id_language)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Language [id_language=" + id_language + ", language=" + language + "]";
	}
}
