/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import by.brsu.portal.cv.Language;
import by.brsu.portal.cv.ProgrammingLanguage;

/**
 * @author Hraznykh_Pavel
 * 
 */
public class User {

	private List<ProgrammingLanguage> progrLanguages;
	private long idUser;
	private String name;
	private String surname;
	private String email;
	private Date dateOfBirth;
	private String telephone;
	private String password;
	private String about;
	private int sex;
	private String skype;
	private String isq;
	private int IQ;
	private long idStat;
	private Blob picture;
	private Date dateOfLastVisit;
	private int numberOfCautions;
	private Status status;
	private List<Language> languagez;
	private List<String> sites;

	/**
	 * @param progrLanguages
	 * @param idUser
	 * @param name
	 * @param surname
	 * @param email
	 * @param dateOfBirth
	 * @param telephone
	 * @param password
	 * @param about
	 * @param sex
	 * @param skype
	 * @param isq
	 * @param iQ
	 * @param idStat
	 * @param picture
	 * @param dateOfLastVisit
	 * @param numberOfCautions
	 * @param status
	 * @param languagez
	 */
	public User(List<ProgrammingLanguage> progrLanguages, longUser,
			String name, String surname, String email, Date dateOfBirth,
			String telephone, String password, String about, int sex,
			String skype, String isq, int iQ, long idStat, Blob picture,
			Date dateOfLastVisit, int numberOfCautions, Status status,
			List<Language> language) {
		super();
		this.progrLanguages = progrLanguages;
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.telephone = telephone;
		this.password = password;
		this.about = about;
		this.sex = sex;
		this.skype = skype;
		this.isq = isq;
		this.IQ = iQ;
		this.idStat = idStat;
		this.picture = picture;
		this.dateOfLastVisit = dateOfLastVisit;
		this.numberOfCautions = numberOfCautions;
		this.status = status;
		this.languagez = language;
	}
	public User()
	{}
	/**
	 * @return the progrLanguages
	 */
	public List<ProgrammingLanguage> getProgrLanguages() {
		return progrLanguages;
	}

	/**
	 * @param progrLanguages
	 *            the progrLanguages to set
	 */
	public void setProgrLanguages(List<ProgrammingLanguage> progrLanguages) {
		this.progrLanguages = progrLanguages;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}

	/**
	 * @param about
	 *            the about to set
	 */
	public void setAbout(String about) {
		this.about = about;
	}

	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @return the skype
	 */
	public String getSkype() {
		return skype;
	}

	/**
	 * @param skype
	 *            the skype to set
	 */
	public void setSkype(String skype) {
		this.skype = skype;
	}

	/**
	 * @return the isq
	 */
	public String getIsq() {
		return isq;
	}

	/**
	 * @param isq
	 *            the isq to set
	 */
	public void setIsq(String isq) {
		this.isq = isq;
	}

	/**
	 * @return the iQ
	 */
	public int getIQ() {
		return IQ;
	}

	/**
	 * @param iQ
	 *            the iQ to set
	 */
	public void setIQ(int iQ) {
		IQ = iQ;
	}

	/**
	 * @return the idStat
	 */
	public long getIdStat() {
		return idStat;
	}

	/**
	 * @param idStat
	 *            the idStat to set
	 */
	public void setIdStat(long idStat) {
		this.idStat = idStat;
	}

	/**
	 * @return the picture
	 */
	public Blob getPicture() {
		return picture;
	}

	/**
	 * @param picture
	 *            the picture to set
	 */
	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	/**
	 * @return the dateOfLastVisit
	 */
	public Date getDateOfLastVisit() {
		return dateOfLastVisit;
	}

	/**
	 * @param dateOfLastVisit
	 *            the dateOfLastVisit to set
	 */
	public void setDateOfLastVisit(Date dateOfLastVisit) {
		this.dateOfLastVisit = dateOfLastVisit;
	}

	/**
	 * @return the numberOfCautions
	 */
	public int getNumberOfCautions() {
		return numberOfCautions;
	}

	/**
	 * @param numberOfCautions
	 *            the numberOfCautions to set
	 */
	public void setNumberOfCautions(int numberOfCautions) {
		this.numberOfCautions = numberOfCautions;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @param languagez
	 *            the languagez to set
	 */
	public void setLanguages(List<Language> language) {
		this.languagez = language;
	}

	/**
	 * @return the languagez
	 */
	public List<Language> getLanguages() {
		return languagez;
	}

	public List<String> getSites() {
		return sites;
	}

	public void setSites(List<String> sites) {
		this.sites = sites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IQ;
		result = prime * result + ((about == null) ? 0 : about.hashCode());
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((dateOfLastVisit == null) ? 0 : dateOfLastVisit.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idStat ^ (idStat >>> 32));
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		result = prime * result + ((isq == null) ? 0 : isq.hashCode());
		result = prime * result
				+ ((languagez == null) ? 0 : languagez.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfCautions;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result
				+ ((progrLanguages == null) ? 0 : progrLanguages.hashCode());
		result = prime * result + sex;
		result = prime * result + ((sites == null) ? 0 : sites.hashCode());
		result = prime * result + ((skype == null) ? 0 : skype.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
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
		User other = (User) obj;
		if (IQ != other.IQ)
			return false;
		if (about == null) {
			if (other.about != null)
				return false;
		} else if (!about.equals(other.about))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfLastVisit == null) {
			if (other.dateOfLastVisit != null)
				return false;
		} else if (!dateOfLastVisit.equals(other.dateOfLastVisit))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idStat != other.idStat)
			return false;
		if (idUser != other.idUser)
			return false;
		if (isq == null) {
			if (other.isq != null)
				return false;
		} else if (!isq.equals(other.isq))
			return false;
		if (languagez == null) {
			if (other.languagez != null)
				return false;
		} else if (!languagez.equals(other.languagez))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfCautions != other.numberOfCautions)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (progrLanguages == null) {
			if (other.progrLanguages != null)
				return false;
		} else if (!progrLanguages.equals(other.progrLanguages))
			return false;
		if (sex != other.sex)
			return false;
		if (sites == null) {
			if (other.sites != null)
				return false;
		} else if (!sites.equals(other.sites))
			return false;
		if (skype == null) {
			if (other.skype != null)
				return false;
		} else if (!skype.equals(other.skype))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [progrLanguages=" + progrLanguages + ", idUser="
				+ idUser + ", name=" + name + ", surname=" + surname
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", telephone=" + telephone + ", password=" + password
				+ ", about=" + about + ", sex=" + sex + ", skype=" + skype
				+ ", isq=" + isq + ", IQ=" + IQ + ", idStat=" + idStat
				+ ", picture=" + picture + ", dateOfLastVisit="
				+ dateOfLastVisit + ", numberOfCautions=" + numberOfCautions
				+ ", status=" + status + ", languagez=" + languagez
				+ ", sites=" + sites + "]";
	}



}