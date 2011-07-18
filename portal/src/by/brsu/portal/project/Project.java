/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

import java.util.Date;
import java.util.List;

import by.brsu.portal.cv.ProgrammingLanguage;
import by.brsu.portal.cv.Technology;

/**
 * @author User
 * 
 */
public class Project {
	private int id_project;
	private int id_owner;
	private char name;
	private char description;
	private Date date_of_creation;
	private Date date_of_closing;
	private ProjectCategory category;
	private int version;
	private char license;
	private char stage_of_development;
	private List<Technology> technology;
	private List<ProgrammingLanguage> languages;

	/**
	 * @param technology
	 *            the technology to set
	 */
	public void setTechnology(List<Technology> technology) {
		this.technology = technology;
	}

	/**
	 * @return the technology
	 */
	public List<Technology> getTechnology() {
		return technology;
	}

	/**
	 * @return the category
	 */
	public ProjectCategory getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(ProjectCategory category) {
		this.category = category;
	}

	/**
	 * @return the id project
	 */
	public int getId_project() {
		return id_project;
	}

	/**
	 * @param set
	 *            id project
	 */
	public void setId_project(int id_project) {
		this.id_project = id_project;
	}

	/**
	 * @return the id user
	 */
	public int getId_owner() {
		return id_owner;
	}

	/**
	 * @param set
	 *            id user
	 */
	public void setId_owner(int id_owner) {
		this.id_owner = id_owner;
	}

	/**
	 * @return the name project
	 */
	public char getName() {
		return name;
	}

	/**
	 * @param set
	 *            name project
	 */
	public void setName(char name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public char getDescription() {
		return description;
	}

	/**
	 * @param set
	 *            description
	 */
	public void setDescription(char description) {
		this.description = description;
	}

	/**
	 * @return the date_of_creation
	 */
	public Date getDate_of_creation() {
		return date_of_creation;
	}

	/**
	 * @param set
	 *            date_of_creation project
	 */
	public void setDate_of_creation(Date date_of_creation) {
		this.date_of_creation = date_of_creation;
	}

	/**
	 * @return the date_of_closing
	 */
	public Date getDate_of_closing() {
		return date_of_closing;
	}

	/**
	 * @param set
	 *            date_of_closing project
	 */
	public void setDate_of_closing(Date date_of_closing) {
		this.date_of_closing = date_of_closing;
	}

	/**
	 * @return the version of project
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param set
	 *            version of project
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the license
	 */
	public char getLicense() {
		return license;
	}

	/**
	 * @param set
	 *            license
	 */
	public void setLicense(char license) {
		this.license = license;
	}

	/**
	 * @return the stage_of_development
	 */
	public char getStage_of_development() {
		return stage_of_development;
	}

	/**
	 * @param set
	 *            stage_of_development
	 */
	public void setStage_of_development(char stage_of_development) {
		this.stage_of_development = stage_of_development;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((date_of_closing == null) ? 0 : date_of_closing.hashCode());
		result = prime
				* result
				+ ((date_of_creation == null) ? 0 : date_of_creation.hashCode());
		result = prime * result + description;
		result = prime * result + id_owner;
		result = prime * result + id_project;
		result = prime * result
				+ ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + license;
		result = prime * result + name;
		result = prime * result + stage_of_development;
		result = prime * result
				+ ((technology == null) ? 0 : technology.hashCode());
		result = prime * result + version;
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
		Project other = (Project) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (date_of_closing == null) {
			if (other.date_of_closing != null)
				return false;
		} else if (!date_of_closing.equals(other.date_of_closing))
			return false;
		if (date_of_creation == null) {
			if (other.date_of_creation != null)
				return false;
		} else if (!date_of_creation.equals(other.date_of_creation))
			return false;
		if (description != other.description)
			return false;
		if (id_owner != other.id_owner)
			return false;
		if (id_project != other.id_project)
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (license != other.license)
			return false;
		if (name != other.name)
			return false;
		if (stage_of_development != other.stage_of_development)
			return false;
		if (technology == null) {
			if (other.technology != null)
				return false;
		} else if (!technology.equals(other.technology))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [id_project=" + id_project + ", id_owner=" + id_owner
				+ ", name=" + name + ", description=" + description
				+ ", date_of_creation=" + date_of_creation
				+ ", date_of_closing=" + date_of_closing + ", category="
				+ category + ", version=" + version + ", license=" + license
				+ ", stage_of_development=" + stage_of_development
				+ ", technology=" + technology + ", languages=" + languages
				+ "]";
	}

	
}
