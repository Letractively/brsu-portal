package by.brsu.portal.cv;

import by.brsu.portal.user.User;
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
	private EduType type_edu;
	private String additional; 
	/**
	 * 
	 */
	public Education(long id_edu, User user, String start_date, String end_date, String edu_name, String place, EduType type_edu, String additional) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additional == null) ? 0 : additional.hashCode());
		result = prime * result + ((edu_name == null) ? 0 : edu_name.hashCode());
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + (int) (id_edu ^ (id_edu >>> 32));
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
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
		Education other = (Education) obj;
		if (additional == null) {
			if (other.additional != null)
				return false;
		} else if (!additional.equals(other.additional))
			return false;
		if (edu_name == null) {
			if (other.edu_name != null)
				return false;
		} else if (!edu_name.equals(other.edu_name))
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (id_edu != other.id_edu)
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Education [id_edu=" + id_edu + ", start_date=" + start_date + ", end_date=" + end_date + ", edu_name="
				+ edu_name + ", place=" + place + ", additional=" + additional + "]";
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

	public EduType getType() {
		return type_edu;
	}

	public void setType_edu(EduType type) {
		this.type_edu = type;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	
	


}
