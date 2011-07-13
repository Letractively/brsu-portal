/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.user;

import java.sql.Blob;

import javax.xml.crypto.Data;

/**
 * @author Hraznykh_Pavel
 *
 */
public class User {
	
		private long id_user;
		private String name;
		private String surname;
		private String email;
		private Data date_of_birth;
		private String telephone;
		private String password;
		private String about;
		private int sex; 
		private String skype; 
		private String isq;
		private int IQ;
		private long id_stat;
		private Blob picture;
		private Data date_of_last_visit;
		private int number_of_cautions;
	
		/**
		 * @param id_user
		 * @param name
		 * @param surname
		 * @param email
		 * @param date_of_birth
		 * @param telephone
		 * @param password
		 * @param about
		 * @param sex
		 * @param skype
		 * @param isq
		 * @param iQ
		 * @param id_stat
		 * @param picture
		 * @param date_of_last_visit
		 * @param number_of_cautions
		 */
		public User(long id_user, String name, String surname, String email, Data date_of_birth, String telephone,
				String password, String about, int sex, String skype, String isq, int iQ, long id_stat, Blob picture,
				Data date_of_last_visit, int number_of_cautions) {
			super();
			this.id_user = id_user;
			this.name = name;
			this.surname = surname;
			this.email = email;
			this.date_of_birth = date_of_birth;
			this.telephone = telephone;
			this.password = password;
			this.about = about;
			this.sex = sex;
			this.skype = skype;
			this.isq = isq;
			IQ = iQ;
			this.id_stat = id_stat;
			this.picture = picture;
			this.date_of_last_visit = date_of_last_visit;
			this.number_of_cautions = number_of_cautions;
		}

		
		/**
		 * @return the id_user
		 */
		public long getId_user() {
			return id_user;
		}
		/**
		 * @param id_user the id_user to set
		 */
		public void setId_user(long id_user) {
			this.id_user = id_user;
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
		 * @return the date_of_birth
		 */
		public Data getDate_of_birth() {
			return date_of_birth;
		}
		/**
		 * @param date_of_birth the date_of_birth to set
		 */
		public void setDate_of_birth(Data date_of_birth) {
			this.date_of_birth = date_of_birth;
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
		 * @return the isq
		 */
		public String getIsq() {
			return isq;
		}
		/**
		 * @param isq the isq to set
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
		 * @param iQ the iQ to set
		 */
		public void setIQ(int iQ) {
			IQ = iQ;
		}
		/**
		 * @return the id_stat
		 */
		public long getId_stat() {
			return id_stat;
		}
		/**
		 * @param id_stat the id_stat to set
		 */
		public void setId_stat(long id_stat) {
			this.id_stat = id_stat;
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
		 * @return the date_of_last_visit
		 */
		public Data getDate_of_last_visit() {
			return date_of_last_visit;
		}
		/**
		 * @param date_of_last_visit the date_of_last_visit to set
		 */
		public void setDate_of_last_visit(Data date_of_last_visit) {
			this.date_of_last_visit = date_of_last_visit;
		}
		/**
		 * @return the number_of_cautions
		 */
		public int getNumber_of_cautions() {
			return number_of_cautions;
		}
		/**
		 * @param number_of_cautions the number_of_cautions to set
		 */
		public void setNumber_of_cautions(int number_of_cautions) {
			this.number_of_cautions = number_of_cautions;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "User [id_user=" + id_user + ", name=" + name + ", surname=" + surname + ", email=" + email
					+ ", date_of_birth=" + date_of_birth + ", telephone=" + telephone + ", password=" + password
					+ ", about=" + about + ", sex=" + sex + ", skype=" + skype + ", isq=" + isq + ", IQ=" + IQ
					+ ", id_stat=" + id_stat + ", picture=" + picture + ", date_of_last_visit=" + date_of_last_visit
					+ ", number_of_cautions=" + number_of_cautions + "]";
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + IQ;
			result = prime * result + ((about == null) ? 0 : about.hashCode());
			result = prime * result + ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
			result = prime * result + ((date_of_last_visit == null) ? 0 : date_of_last_visit.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + (int) (id_stat ^ (id_stat >>> 32));
			result = prime * result + (int) (id_user ^ (id_user >>> 32));
			result = prime * result + ((isq == null) ? 0 : isq.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + number_of_cautions;
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((picture == null) ? 0 : picture.hashCode());
			result = prime * result + sex;
			result = prime * result + ((skype == null) ? 0 : skype.hashCode());
			result = prime * result + ((surname == null) ? 0 : surname.hashCode());
			result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
			User other = (User) obj;
			if (IQ != other.IQ)
				return false;
			if (about == null) {
				if (other.about != null)
					return false;
			} else if (!about.equals(other.about))
				return false;
			if (date_of_birth == null) {
				if (other.date_of_birth != null)
					return false;
			} else if (!date_of_birth.equals(other.date_of_birth))
				return false;
			if (date_of_last_visit == null) {
				if (other.date_of_last_visit != null)
					return false;
			} else if (!date_of_last_visit.equals(other.date_of_last_visit))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (id_stat != other.id_stat)
				return false;
			if (id_user != other.id_user)
				return false;
			if (isq == null) {
				if (other.isq != null)
					return false;
			} else if (!isq.equals(other.isq))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (number_of_cautions != other.number_of_cautions)
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
			if (sex != other.sex)
				return false;
			if (skype == null) {
				if (other.skype != null)
					return false;
			} else if (!skype.equals(other.skype))
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
	
}
