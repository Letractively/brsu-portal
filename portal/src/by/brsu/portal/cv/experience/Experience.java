/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

/**
 * @author Oleg Panasyuk
 *
 */
public class Experience {
	private long id_experience;
	private String start_date;
	private String end_date;
	private String company_name;
	private Position position;
	private String additional;
	private Project project;
	private User user;
	
	/**
	 * 
	 */
	public Experience(long id_experience, String start_date, String end_date, String company_name, Position position, String additional, Project project, User user) {
		// TODO Auto-generated constructor stub
		this.id_experience = id_experience;
		this.start_date = start_date;
		this.end_date = end_date;
		this.company_name = company_name;
		this.position = position;
		this.additional = additional;
		this.project = project;
		this.user = user;
	}

	public long getId_experience() {
		return id_experience;
	}

	public void setId_experience(long id_experience) {
		this.id_experience = id_experience;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
