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
	private long idPrHistory;
	private long idProject;
	private long idUser;
	private String stage;
	private String name;

	/**
	 * 
	 */
	public ProjectHistory() {
		super();
	}

	/**
	 * @param idPrHistory
	 * @param idProject
	 * @param idUser
	 * @param stage
	 * @param name
	 */
	public ProjectHistory(long idPrHistory, long idProject, long idUser,
			String stage, String name) {
		super();
		this.idPrHistory = idPrHistory;
		this.idProject = idProject;
		this.idUser = idUser;
		this.stage = stage;
		this.name = name;
	}

	/**
	 * @return the idPrHistory
	 */
	public long getIdPrHistory() {
		return idPrHistory;
	}

	/**
	 * @param idPrHistory
	 *            the idPrHistory to set
	 */
	public void setIdPrHistory(long idPrHistory) {
		this.idPrHistory = idPrHistory;
	}

	/**
	 * @return the idProject
	 */
	public long getIdProject() {
		return idProject;
	}

	/**
	 * @param idProject
	 *            the idProject to set
	 */
	public void setIdProject(long idProject) {
		this.idProject = idProject;
	}

	/**
	 * @return the idUser
	 */
	public long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 *            the idUser to set
	 */
	public void setIdUser(long idUser) {
		this.idUser = idUser;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPrHistory ^ (idPrHistory >>> 32));
		result = prime * result + (int) (idProject ^ (idProject >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stage == null) ? 0 : stage.hashCode());
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
		if (idPrHistory != other.idPrHistory)
			return false;
		if (idProject != other.idProject)
			return false;
		if (idUser != other.idUser)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stage == null) {
			if (other.stage != null)
				return false;
		} else if (!stage.equals(other.stage))
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
		return "ProjectHistory [idPrHistory=" + idPrHistory + ", idProject="
				+ idProject + ", idUser=" + idUser + ", stage=" + stage
				+ ", name=" + name + "]";
	}
}
