package Education;
/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

/**
 * @author Oleg Panasyuk
 *
 */
public class Education {
	private long id_edu;
	private User user;
	private String start_date;
	private String end_date;
	private String edu_name;
	private String place;
	private Type_edu type_edu;
	private String additional; 
	/**
	 * 
	 */
	public Education(long id_edu, User user, String start_date, String end_date, String edu_name, String place, Type_edu type_edu, String additional) {
		// TODO Auto-generated constructor stub
		this.id_edu = id_edu;
		this.user = user; 
		this.start_date = start_date;
		this.end_date = end_date;
		this.edu_name = edu_name;
		this.place = place;
		this.type_edu = type_edu;
		this.additional = additional;
	}
	
	public long getId_edu() {
		return id_edu;
	}

	public void setId_edu(long id_edu) {
		this.id_edu = id_edu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getEdu_name() {
		return edu_name;
	}

	public void setEdu_name(String edu_name) {
		this.edu_name = edu_name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Type_edu getType_edu() {
		return type_edu;
	}

	public void setType_edu(Type_edu type_edu) {
		this.type_edu = type_edu;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	
	


}
