package by.brsu.portal.vacancy;

import by.brsu.portal.cv.Education;
import by.brsu.portal.cv.ProgrammingLanguage;


public class Vacancy {

	private long id;
	private String post;//должность 
	private long quantityOfPlaces;//кол. мест
	private ProgrammingLanguage programmingLanguage;//€зык программировани€
	private long experience;//опыт работы
	private long age;//возраст
	private Education education;//образование
	private String employment;//зан€тость
	private String workPlace;//место работы
	private String sex;// пол
	private String region;//регион
	private long realizationTerm;// срок реализации
	private long salary;// зарплата
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the post
	 */
	public String getPost() {
		return post;
	}
	/**
	 * @param post the post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * @return the quantityOfPlaces
	 */
	public long getQuantityOfPlaces() {
		return quantityOfPlaces;
	}
	/**
	 * @param quantityOfPlaces the quantityOfPlaces to set
	 */
	public void setQuantityOfPlaces(long quantityOfPlaces) {
		this.quantityOfPlaces = quantityOfPlaces;
	}
	/**
	 * @return the programmingLanguage
	 */
	public ProgrammingLanguage getProgrammingLanguage() {
		return programmingLanguage;
	}
	/**
	 * @param programmingLanguage the programmingLanguage to set
	 */
	public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	/**
	 * @return the experience
	 */
	public long getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(long experience) {
		this.experience = experience;
	}
	/**
	 * @return the age
	 */
	public long getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(long age) {
		this.age = age;
	}
	/**
	 * @return the education
	 */
	public Education getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(Education education) {
		this.education = education;
	}
	/**
	 * @return the employment
	 */
	public String getEmployment() {
		return employment;
	}
	/**
	 * @param employment the employment to set
	 */
	public void setEmployment(String employment) {
		this.employment = employment;
	}
	/**
	 * @return the workPlace
	 */
	public String getWorkPlace() {
		return workPlace;
	}
	/**
	 * @param workPlace the workPlace to set
	 */
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the realizationTerm
	 */
	public long getRealizationTerm() {
		return realizationTerm;
	}
	/**
	 * @param realizationTerm the realizationTerm to set
	 */
	public void setRealizationTerm(long realizationTerm) {
		this.realizationTerm = realizationTerm;
	}
	/**
	 * @return the salary
	 */
	public long getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(long salary) {
		this.salary = salary;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (age ^ (age >>> 32));
		result = prime * result
				+ ((education == null) ? 0 : education.hashCode());
		result = prime * result
				+ ((employment == null) ? 0 : employment.hashCode());
		result = prime * result + (int) (experience ^ (experience >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime
				* result
				+ ((programmingLanguage == null) ? 0 : programmingLanguage
						.hashCode());
		result = prime * result
				+ (int) (quantityOfPlaces ^ (quantityOfPlaces >>> 32));
		result = prime * result
				+ (int) (realizationTerm ^ (realizationTerm >>> 32));
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + (int) (salary ^ (salary >>> 32));
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result
				+ ((workPlace == null) ? 0 : workPlace.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacancy other = (Vacancy) obj;
		if (age != other.age)
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (employment == null) {
			if (other.employment != null)
				return false;
		} else if (!employment.equals(other.employment))
			return false;
		if (experience != other.experience)
			return false;
		if (id != other.id)
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (programmingLanguage == null) {
			if (other.programmingLanguage != null)
				return false;
		} else if (!programmingLanguage.equals(other.programmingLanguage))
			return false;
		if (quantityOfPlaces != other.quantityOfPlaces)
			return false;
		if (realizationTerm != other.realizationTerm)
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (salary != other.salary)
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (workPlace == null) {
			if (other.workPlace != null)
				return false;
		} else if (!workPlace.equals(other.workPlace))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vacancy [age=" + age + ", education=" + education
				+ ", employment=" + employment + ", experience=" + experience
				+ ", id=" + id + ", post=" + post + ", programmingLanguage="
				+ programmingLanguage + ", quantityOfPlaces="
				+ quantityOfPlaces + ", realizationTerm=" + realizationTerm
				+ ", region=" + region + ", salary=" + salary + ", sex=" + sex
				+ ", workPlace=" + workPlace + "]";
	}
	/**
	 * @param id
	 * @param post
	 * @param quantityOfPlaces
	 * @param programmingLanguage
	 * @param experience
	 * @param age
	 * @param education
	 * @param employment
	 * @param workPlace
	 * @param sex
	 * @param region
	 * @param realizationTerm
	 * @param salary
	 */
	public Vacancy(long id, String post, long quantityOfPlaces,
			ProgrammingLanguage programmingLanguage, long experience, long age,
			Education education, String employment, String workPlace,
			String sex, String region, long realizationTerm, long salary) {
		super();
		this.id = id;
		this.post = post;
		this.quantityOfPlaces = quantityOfPlaces;
		this.programmingLanguage = programmingLanguage;
		this.experience = experience;
		this.age = age;
		this.education = education;
		this.employment = employment;
		this.workPlace = workPlace;
		this.sex = sex;
		this.region = region;
		this.realizationTerm = realizationTerm;
		this.salary = salary;
	}
	/**
	 * 
	 */
	public Vacancy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
}
