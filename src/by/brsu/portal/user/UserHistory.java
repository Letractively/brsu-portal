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
public class UserHistory {
	private long id;
	private long idUser;
	private Date date;
	private String name;
	private String surname;
	private long idStatus;
	private int iq;
	private int numberOfCations;

	/**
	 * 
	 */
	public UserHistory() {
	}

	/**
	 * @param id
	 * @param idUser
	 * @param date
	 * @param name
	 * @param surname
	 * @param idStatus
	 * @param iq
	 * @param numberOfCations
	 */
	public UserHistory(long id, long idUser, Date date, String name,
			String surname, long idStatus, int iq, int numberOfCations) {
		this.id = id;
		this.idUser = idUser;
		this.date = date;
		this.name = name;
		this.surname = surname;
		this.idStatus = idStatus;
		this.iq = iq;
		this.numberOfCations = numberOfCations;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the idStatus
	 */
	public long getIdStatus() {
		return idStatus;
	}

	/**
	 * @param idStatus
	 *            the idStatus to set
	 */
	public void setIdStatus(long idStatus) {
		this.idStatus = idStatus;
	}

	/**
	 * @return the iq
	 */
	public int getIq() {
		return iq;
	}

	/**
	 * @param iq
	 *            the iq to set
	 */
	public void setIq(int iq) {
		this.iq = iq;
	}

	/**
	 * @return the numberOfCations
	 */
	public int getNumberOfCations() {
		return numberOfCations;
	}

	/**
	 * @param numberOfCations
	 *            the numberOfCations to set
	 */
	public void setNumberOfCations(int numberOfCations) {
		this.numberOfCations = numberOfCations;
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
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (idStatus ^ (idStatus >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		result = prime * result + iq;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfCations;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		UserHistory other = (UserHistory) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (idStatus != other.idStatus)
			return false;
		if (idUser != other.idUser)
			return false;
		if (iq != other.iq)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfCations != other.numberOfCations)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
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
		return "UserHistory [id=" + id + ", idUser=" + idUser + ", date="
				+ date + ", name=" + name + ", surname=" + surname
				+ ", idStatus=" + idStatus + ", iq=" + iq
				+ ", numberOfCations=" + numberOfCations + "]";
	}
}
