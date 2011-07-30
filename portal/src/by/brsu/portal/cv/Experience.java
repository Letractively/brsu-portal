package by.brsu.portal.cv;

import by.brsu.portal.project.Project;
/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
import by.brsu.portal.user.User;

/**
 * @author Oleg Panasyuk
 *
 */
public class Experience {
	private long id;
	private String startDate;
	private String endDate;
	private String companyName;
	private Position position;
	private String additional;
	private Project project;
	private User user;
	
	/**
	 * 
	 */
	public Experience(long id, String startDate, String endDate, String companyName, Position position, String additional, Project project, User user) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.companyName = companyName;
		this.position = position;
		this.additional = additional;
		this.project = project;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	@Override
	public String toString() {
		return "Experience [id_experience=" + id + ", start_date=" + startDate + ", end_date=" + endDate
				+ ", company_name=" + companyName + ", additional=" + additional + "]";
	}

}
