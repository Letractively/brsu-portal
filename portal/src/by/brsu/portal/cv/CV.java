/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
import java.util.List;
/**
 * @author user
 *
 */
public class CV {
	
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

	public List<String> getLangueges() {
		return langueges;
	}

	public void addLanguege(String languege) {
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

	public void addAdditional(String additional) {
		this.additional = this.additional + additional;
	}

}


