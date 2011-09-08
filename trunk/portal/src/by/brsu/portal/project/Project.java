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
 * @author Artur Smaliuk
 * 
 */
public class Project 
{
	private long idProject;
	private int idOwner;
	private String name;
	private String description;
	private Date dateOfCreation;
	private Date dateOfClosing;
	private ProjectCategory category;
	private int version;
	private String license;
	private String stageOfDevelopment;
	private List<Technology> technology;
	private List<ProgrammingLanguage> languages;
	
	/**
	 * 
	 */
	public Project() 
	{
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public Project(long idProject, int idOwner, String name, String description, Date dateOfCreation, Date dateOfClosing, 
			ProjectCategory category, int version, String license, String stageOfDevelopment, 
			List<Technology> technology, List<ProgrammingLanguage> languages) 
	{
		super();
		this.idProject = idProject;
		this.idOwner = idOwner;
		this.name = name;
		this.description = description;
		this.dateOfCreation = dateOfCreation;
		this.dateOfClosing = dateOfClosing;
		this.category = category;
		this.version = version;
		this.license = license;
		this.stageOfDevelopment = stageOfDevelopment;
		this.technology = technology;
		this.languages = languages;		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Project [idProject=" + idProject + ", idOwner=" + idOwner
				+ ", name=" + name + ", description=" + description
				+ ", dateOfCreation=" + dateOfCreation + ", dateOfClosing="
				+ dateOfClosing + ", category=" + category + ", version="
				+ version + ", license=" + license + ", stageOfDevelopment="
				+ stageOfDevelopment + ", technology=" + technology
				+ ", languages=" + languages + "]";
	}
	
	/**
	 * @return the idProject
	 */
	public long getIdProject() 
	{
		return idProject;
	}
	
	/**
	 * @param set idProject
	 */
	public void setIdProject(long idProject) 
	{
		this.idProject = idProject;
	}
	
	/**
	 * @return the idOwner
	 */
	public int getIdOwner() 
	{
		return idOwner;
	}
	
	/**
	 * @param set idOwner
	 */
	public void setIdOwner(int idOwner) 
	{
		this.idOwner = idOwner;
	}
	
	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * @param set name project
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() 
	{
		return description;
	}
	
	/**
	 * @param set description
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	/**
	 * @return the dateOfCreation
	 */
	public Date getDateOfCreation() 
	{
		return dateOfCreation;
	}
	
	/**
	 * @param set dateOfCreation project
	 */
	public void setDateOfCreation(Date dateOfCreation) 
	{
		this.dateOfCreation = dateOfCreation;
	}
	
	/**
	 * @return the dateOfClosing
	 */
	public Date getDateOfClosing() 
	{
		return dateOfClosing;
	}
	
	/**
	 * @param set dateOfClosing project
	 */
	public void setDateOfClosing(Date dateOfClosing) 
	{
		this.dateOfClosing = dateOfClosing;
	}
	
	/**
	 * @return the category
	 */
	public ProjectCategory getCategory() 
	{
		return category;
	}
	
	/**
	 * @param set category
	 */
	public void setCategoryForOne(String categoryParametr) 
	{
		this.category.setName(categoryParametr);
	}
	public void setCategory(ProjectCategory category) 
	{
		this.category = category;
	}
	
	/**
	 * @return the version
	 */
	public int getVersion() 
	{
		return version;
	}
	
	/**
	 * @param set version
	 */
	public void setVersion(int version)
	{
		this.version = version;
	}
	
	/**
	 * @return the license
	 */
	public String getLicense()
	{
		return license;
	}
	
	/**
	 * @param set license
	 */
	public void setLicense(String license) 
	{
		this.license = license;
	}
	
	/**
	 * @return the stageOfDevelopment
	 */
	public String getStageOfDevelopment() 
	{
		return stageOfDevelopment;
	}
	
	/**
	 * @param set stageOfDevelopment
	 */
	public void setStageOfDevelopment(String stageOfDevelopment) 
	{
		this.stageOfDevelopment = stageOfDevelopment;
	}
	
	/**
	 * @return the technology
	 */
	public List<Technology> getTechnology() 
	{
		return technology;
	}
	
	/**
	 * @param set technology
	 */
	public void setTechnologyForOne(String technology) 
	{
		Technology tech = new Technology();
		tech.setName(technology);
		this.technology.add(tech);
	}
	public void setTechnology(List<Technology> technology) 
	{
		this.technology = technology;
	}
	
	/**
	 * @return the languages
	 */
	public List<ProgrammingLanguage> getLanguages() 
	{
		return languages;
	}
	
	/**
	 * @param set languages
	 */
	public void setLanguagesForOne(String languages) 
	{
		ProgrammingLanguage proglang = new ProgrammingLanguage();
		proglang.setName(languages);
		this.languages.add(proglang);
	}
	public void setLanguages(List<ProgrammingLanguage> languages) 
	{
		this.languages = languages;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((dateOfClosing == null) ? 0 : dateOfClosing.hashCode());
		result = prime * result
				+ ((dateOfCreation == null) ? 0 : dateOfCreation.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + idOwner;
		result = prime * result + (int) (idProject ^ (idProject >>> 32));
		result = prime * result
				+ ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((stageOfDevelopment == null) ? 0 : stageOfDevelopment
						.hashCode());
		result = prime * result
				+ ((technology == null) ? 0 : technology.hashCode());
		result = prime * result + version;
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
		Project other = (Project) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateOfClosing == null) {
			if (other.dateOfClosing != null)
				return false;
		} else if (!dateOfClosing.equals(other.dateOfClosing))
			return false;
		if (dateOfCreation == null) {
			if (other.dateOfCreation != null)
				return false;
		} else if (!dateOfCreation.equals(other.dateOfCreation))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idOwner != other.idOwner)
			return false;
		if (idProject != other.idProject)
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stageOfDevelopment == null) {
			if (other.stageOfDevelopment != null)
				return false;
		} else if (!stageOfDevelopment.equals(other.stageOfDevelopment))
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

		
	
}
