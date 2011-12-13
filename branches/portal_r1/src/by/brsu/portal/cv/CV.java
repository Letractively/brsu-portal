package by.brsu.portal.cv;

/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
import java.util.List;

import by.brsu.portal.user.User;

/**
 * @author user
 * 
 */
public class CV {
	private User user;
	private List<Experience> experiences;
	private List<Language> langueges;
	private List<String> hobbies;
	private List<String> technologies;
	private List<String> links;
	private List<Education> educations;
	private String additional;

	/**
	 * 
	 */
	public CV() {
		// TODO Auto-generated constructor stub
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void addExperience(Experience experience) {
		experiences.add(experience);
	}

	public void deleteExperience(int id_remove) {
		experiences.remove(id_remove);
	}

	public List<Language> getLangueges() {
		return langueges;
	}

	public void addLanguege(Language languege) {
		langueges.add(languege);
	}

	public void deleteLanguege(int id_remove) {
		langueges.remove(id_remove);
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void addHobby(String hobby) {
		hobbies.add(hobby);
	}

	public void deleteHobby(int id_remove) {
		hobbies.remove(id_remove);
	}

	public List<String> getTechnologies() {
		return technologies;
	}

	public void addTechnology(String technology) {
		technologies.add(technology);
	}

	public void deleteTechnology(int id_remove) {
		technologies.remove(id_remove);
	}

	public List<String> getLinks() {
		return links;
	}

	public void addLinks(String link) {
		links.add(link);
	}

	public void deleteLinks(int id_remove) {
		links.remove(id_remove);
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void addEducation(Education education) {
		educations.add(education);
	}

	public void deleteEducation(int id_remove) {
		educations.remove(id_remove);
	}

	public String getAdditional() {
		return additional;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addAdditional(String additional) {
		this.additional = this.additional + additional;
	}

	@Override
	public String toString() {
		return "CV [hobbies=" + hobbies + ", technologies=" + technologies + ", links=" + links + ", additional="
				+ additional + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((additional == null) ? 0 : additional.hashCode());
		result = prime * result
				+ ((educations == null) ? 0 : educations.hashCode());
		result = prime * result
				+ ((experiences == null) ? 0 : experiences.hashCode());
		result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
		result = prime * result
				+ ((langueges == null) ? 0 : langueges.hashCode());
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result
				+ ((technologies == null) ? 0 : technologies.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		CV other = (CV) obj;
		if (additional == null) {
			if (other.additional != null)
				return false;
		} else if (!additional.equals(other.additional))
			return false;
		if (educations == null) {
			if (other.educations != null)
				return false;
		} else if (!educations.equals(other.educations))
			return false;
		if (experiences == null) {
			if (other.experiences != null)
				return false;
		} else if (!experiences.equals(other.experiences))
			return false;
		if (hobbies == null) {
			if (other.hobbies != null)
				return false;
		} else if (!hobbies.equals(other.hobbies))
			return false;
		if (langueges == null) {
			if (other.langueges != null)
				return false;
		} else if (!langueges.equals(other.langueges))
			return false;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (technologies == null) {
			if (other.technologies != null)
				return false;
		} else if (!technologies.equals(other.technologies))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
