/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;


/**
 * @author Roman Ulezlo
 * 
 */
public class ProjectHistory {
	private long id;
	private long project;
	private long user;
	private String stage;
	private String name;

	/**
	 * 
	 */
	public ProjectHistory() {
		super();
	}

	/**
	 * @param project
	 * @param user
	 * @param stage
	 * @param name
	 */
	public ProjectHistory(long project, long user, String stage, String name) {
		super();
		this.project = project;
		this.user = user;
		this.stage = stage;
		this.name = name;
	}

	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the project
	 */
	public long getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(long project) {
		this.project = project;
	}

	/**
	 * @return the user
	 */
	public long getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(long user) {
		this.user = user;
	}

	/**
	 * @return the stage
	 */
	public String getStage() {
		return stage;
	}

	/**
	 * @param stage
	 *            the stage to set
	 */
	public void setStage(String stage) {
		this.stage = stage;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (project ^ (project >>> 32));
		result = prime * result + ((stage == null) ? 0 : stage.hashCode());
		result = prime * result + (int) (user ^ (user >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		ProjectHistory other = (ProjectHistory) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (project != other.project)
			return false;
		if (stage == null) {
			if (other.stage != null)
				return false;
		} else if (!stage.equals(other.stage))
			return false;
		if (user != other.user)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectHistory [id=" + id + ", project=" + project + ", user="
				+ user + ", stage=" + stage + ", name=" + name + "]";
	}
}
