package by.brsu.portal.vacancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.brsu.portal.cv.Education;
import by.brsu.portal.cv.ProgrammingLanguage;

/**
 * @author Sasha Koldushko
 *
 */

public class VacancyDAO {
	  Connection connection = null;
	  String nameUser = "root";
	  String url = "jdbc:mysql://localhost/main"; 
	  String passwd = "";
	 
	/**
	 * create table vacancy
	 */

	 public  void createTableVacancy (){
		 
		 
		 try {
			connection = DriverManager.getConnection(nameUser, passwd, url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		String st =  "create table vacancy (id_vacancy int not null auto_increment primary key," +
				"post varchar(20) not null," +
				"quantity_of_places int(20) not null," +
				"programming_language varchar(20) not null," +
				"experience int(20) not null," +
				"age int (20) not null," +
				"education varchar(20) not null," +
				"employment varchar(20) not null," +
				"work_place varchar(20) not null," +
				"sex varchar(20) not null," +
				"region varchar(20) not null," +
				"realization_term int(20) not null" +
				"salary int(100) not null";
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(st);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try {
					if (statement != null)
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
                     
	 }
	 /**
	  * delete table vacancy
	  */
	 
	 
	public void deleteTableVacancy (){
		 
		 try {
			connection = DriverManager.getConnection(nameUser, passwd, url);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String st = "DROP TABLE VACANCY";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if (statement != null)
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	 }
	 
	 
	 /**
	  * insert into table vacancy values 
	 * @param post
	 * @param quantityOfPlaces
	 * @param programmingLanguage
	 * @param experience
	 * @param age
	 * @param education
	 * @param employment
	 * @param workPlace
	 * @param sex
	 * @param region
	 * @param realizationTerm
	 * @param salary
	 * @return
	 */
	public Vacancy createVacancy (String post, long quantityOfPlaces, ProgrammingLanguage programmingLanguage, 
			 long experience, long age, Education education, String employment, String workPlace,String sex
			 , String region, long realizationTerm, long salary){
		 
		 try {
			connection = DriverManager.getConnection(nameUser, passwd, url);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String st = "insert into vacancy values (null,'" + post +  "'," + quantityOfPlaces + ",'" + programmingLanguage + "'," +
		experience + "," + age + ",'" + education + "','" + employment + "','" + workPlace + "','" + sex + "','" + region + "'," +
		realizationTerm + "," + salary + ")";
		String select = "select * from vacancy where post = '" + post + "'";
		ResultSet result = null;
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(st);
			result = statement.executeQuery(select);
			
			if (result.next()){
				Vacancy vacancy = new Vacancy();
				vacancy.setPost(post);
				vacancy.setId(result.getLong(1));
				vacancy.setQuantityOfPlaces(quantityOfPlaces);
				vacancy.setProgrammingLanguage(programmingLanguage);
				vacancy.setExperience(experience);
				vacancy.setAge(age);
				vacancy.setEducation(education);
				vacancy.setEmployment(employment);
				vacancy.setWorkPlace(workPlace);
				vacancy.setSex(sex);
				vacancy.setRegion(region);
				vacancy.setRealizationTerm(realizationTerm);
				vacancy.setSalary(salary);
				
				return vacancy;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if (statement != null)
					statement.close();
					if (result != null)
						result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
		 
	 }
	 
	 
	 /**
	  * find  values  in the table vacancy by salary 
	  * @param salary
	  * @return
	  */
	public Vacancy findVacancyBySalary (long salary){
		 
		 try {
			connection = DriverManager.getConnection(nameUser, passwd, url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String st = "select * from vacancy where salary = " + salary;
		ResultSet result = null;
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(st);
			
			if (result.next()){
				Vacancy vacancy = new Vacancy(); 
				vacancy.setSalary(salary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if (statement != null)
					    statement.close();
					if (result != null)
						result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		

		 
		return null;
		 
		 
	 }
}
