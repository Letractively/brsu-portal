package by.brsu.portal.cv;
import by.brsu.portal.uset.*;
/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */

/**
 * @author Oleg Panasyuk
 *
 */
public class Education {
	private long id;
	private User user;
	private String startDate;
	private String endDate;
	private String eduName;
	private String place;
	private EduType typeEdu;
	private String additional; 
	/**
	 * 
	 */
	public Education(long id, User user, String startDate, String endDate, String eduName, String place, EduType typeEdu, String additional) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.user = user; 
		this.startDate = startDate;
		this.endDate = endDate;
		this.eduName = eduName;
		this.place = place;
		this.typeEdu = typeEdu;
		this.additional = additional;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additional == null) ? 0 : additional.hashCode());
		result = prime * result + ((eduName == null) ? 0 : eduName.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		if (eduName == null) {
			if (other.eduName != null)
				return false;
		} else if (!eduName.equals(other.eduName))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Education [id_edu=" + id + ", start_date=" + startDate + ", end_date=" + endDate + ", edu_name="
				+ eduName + ", place=" + place + ", additional=" + additional + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id_edu) {
		this.id = id_edu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getEduName() {
		return eduName;
	}

	public void setEduName(String eduName) {
		this.eduName = eduName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public EduType getTypeEdu() {
		return typeEdu;
	}

	public void setTypeEdu(EduType typeEdu) {
		this.typeEdu = typeEdu;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	
	


}
