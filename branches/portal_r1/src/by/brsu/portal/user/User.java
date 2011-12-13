/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import by.brsu.portal.cv.ProgrammingLanguage;
import by.brsu.portal.cv.Language;
/**
 * @author Hraznykh_Pavel
 * 
 */
public class User {

	private List<ProgrammingLanguage> progrLanguages;
	private long Id;
	private String name;
	private String surname;
	private String email;
	private Date dateOfBirth;
	private String telephone;
	private String password;
	private String about;
	private int sex;
	private String skype;
	private String icq; // change isq on icq
	private int IQ;
	private long idStat;
	private Blob picture;
	private Date dateOfLastVisit;
	private int numberOfCautions;
	private Status status;
	private List<Language> languagez;
	private List<String> sites;
	private Role role;
	/**
	 * @param progrLanguages
	 * @param id
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
	 * @param sites
	 * @param role
	 */
	public User(List<ProgrammingLanguage> progrLanguages, long id, String name, String surname, String email,
			Date dateOfBirth, String telephone, String password, String about, int sex, String skype, String icq,
			int iQ, long idStat, Blob picture, Date dateOfLastVisit, int numberOfCautions, Status status,
			List<Language> languagez, List<String> sites, Role role) {
		super();
		this.progrLanguages = progrLanguages;
		Id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.telephone = telephone;
		this.password = password;
		this.about = about;
		this.sex = sex;
		this.skype = skype;
		this.icq = icq;
		IQ = iQ;
		this.idStat = idStat;
		this.picture = picture;
		this.dateOfLastVisit = dateOfLastVisit;
		this.numberOfCautions = numberOfCautions;
		this.status = status;
		this.languagez = languagez;
		this.sites = sites;
		this.role = role;
	}
	public User() {
		// TODO Auto-generated constructor stub
	super();
	}
	/**
	 * @return the progrLanguages
	 */
	public List<ProgrammingLanguage> getProgrLanguages() {
		return progrLanguages;
	}
	/**
	 * @param progrLanguages the progrLanguages to set
	 */
	public void setProgrLanguages(List<ProgrammingLanguage> progrLanguages) {
		this.progrLanguages = progrLanguages;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		Id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
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
	 * @param surname the surname to set
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
	 * @param email the email to set
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
	 * @param dateOfBirth the dateOfBirth to set
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
	 * @param telephone the telephone to set
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
	 * @param password the password to set
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
	 * @param about the about to set
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
	 * @param sex the sex to set
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
	 * @param skype the skype to set
	 */
	public void setSkype(String skype) {
		this.skype = skype;
	}
	/**
	 * @return the icq
	 */
	public String getIcq() {
		return icq;
	}
	/**
	 * @param icq the icq to set
	 */
	public void setIcq(String icq) {
		this.icq = icq;
	}
	/**
	 * @return the iQ
	 */
	public int getIQ() {
		return IQ;
	}
	/**
	 * @param iQ the iQ to set
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
	 * @param idStat the idStat to set
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
	 * @param picture the picture to set
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
	 * @param dateOfLastVisit the dateOfLastVisit to set
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
	 * @param numberOfCautions the numberOfCautions to set
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
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the languagez
	 */
	public List<Language> getLanguagez() {
		return languagez;
	}
	/**
	 * @param languagez the languagez to set
	 */
	public void setLanguagez(List<Language> languagez) {
		this.languagez = languagez;
	}
	/**
	 * @return the sites
	 */
	public List<String> getSites() {
		return sites;
	}
	/**
	 * @param sites the sites to set
	 */
	public void setSites(List<String> sites) {
		this.sites = sites;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}


}