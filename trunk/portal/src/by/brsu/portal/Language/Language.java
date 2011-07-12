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

}
