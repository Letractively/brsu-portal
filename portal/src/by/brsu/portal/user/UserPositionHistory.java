/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

import java.util.Date;

/**
 * @author Roman Ulezlo
 * 
 */
public class UserPositionHistory {
	private long idUserPositionHistory;
	private long idUser;
	private Date date;
	private long idPosition;
	private long idProject;

	/**
	 * 
	 */
	public UserPositionHistory() {
		super();
	}

	/**
	 * @param idUserPositionHistory
	 * @param idUser
	 * @param date
	 * @param idPosition
	 * @param idProject
	 */
	public UserPositionHistory(long idUserPositionHistory, long idUser,
			Date date, long idPosition, long idProject) {
		super();
		this.idUserPositionHistory = idUserPositionHistory;
		this.idUser = idUser;
		this.date = date;
		this.idPosition = idPosition;
		this.idProject = idProject;
	}

	/**
	 * @return the idUserPositionHistory
	 */
	public long getIdUserPositionHistory() {
		return idUserPositionHistory;
	}

	/**
	 * @param idUserPositionHistory
	 *            the idUserPositionHistory to set
	 */
	public void setIdUserPositionHistory(long idUserPositionHistory) {
		this.idUserPositionHistory = idUserPositionHistory;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the idPosition
	 */
	public long getIdPosition() {
		return idPosition;
	}

	/**
	 * @param idPosition
	 *            the idPosition to set
	 */
	public void setIdPosition(long idPosition) {
		this.idPosition = idPosition;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (idPosition ^ (idPosition >>> 32));
		result = prime * result + (int) (idProject ^ (idProject >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		result = prime
				* result
				+ (int) (idUserPositionHistory ^ (idUserPositionHistory >>> 32));
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
		UserPositionHistory other = (UserPositionHistory) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idPosition != other.idPosition)
			return false;
		if (idProject != other.idProject)
			return false;
		if (idUser != other.idUser)
			return false;
		if (idUserPositionHistory != other.idUserPositionHistory)
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
		return "UserPositionHistory [idUserPositionHistory="
				+ idUserPositionHistory + ", idUser=" + idUser + ", date="
				+ date + ", idPosition=" + idPosition + ", idProject="
				+ idProject + "]";
	}
}
