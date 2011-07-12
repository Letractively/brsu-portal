/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

/**
 * @author Oleg Panasyuk
 * 
 */
public class L_language_pr {
	private Project project;
	private Language language;

	/**
	 * 
	 */
	public L_language_pr(Project project, Language language) {
		// TODO Auto-generated constructor stub
		this.language = language;
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}
