package by.brsu.portal.vacancy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import by.brsu.portal.ConnectionManager;
import by.brsu.portal.cv.Education;
import by.brsu.portal.cv.ProgrammingLanguage;
/**
 * @author Sasha Koldushko
 * 
 */

public class VacancyDAO {
	private Connection connection ;
	private static final Logger log = Logger.getLogger(VacancyDAO.class);
	/**
	 * insert into table vacancy values
	 * 
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
	 * @throws IOException 
	 */
	public Vacancy createVacancy(String post, long quantityOfPlaces,
			ProgrammingLanguage programmingLanguage, long experience, long age,
			Education education, String employment, String workPlace,
			String sex, String region, long realizationTerm, long salary) throws IOException {
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		connection = ConnectionManager.getConnectorPool().getConnection();
		String st = "insert into vacancy values (null,'" + post + "',"
				+ quantityOfPlaces + ",'" + programmingLanguage + "',"
				+ experience + "," + age + ",'" + education + "','"
				+ employment + "','" + workPlace + "','" + sex + "','" + region
				+ "'," + realizationTerm + "," + salary + ")";
		String select = "select * from vacancy where post = '" + post + "'";
		ResultSet result = null;
		Statement statement = null;

		try {
			statement = connection.createStatement();
			statement.executeUpdate(st);
			result = statement.executeQuery(select);

			if (result.next()) {
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
			log.error(e);
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (result != null)
					result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
			ConnectionManager.getConnectorPool().releaseConnection(connection);

		}
		return null;

	}

	/**
	 * find values in the table vacancy by salary
	 * 
	 * @param salary
	 * @return
	 * @throws IOException 
	 */
	public Vacancy findVacancyBySalary(long salary) throws IOException {

		connection = ConnectionManager.getConnectorPool().getConnection();
		String st = "select * from vacancy where salary = " + salary;
		ResultSet result = null;
		Statement statement = null;
		SimpleLayout layout = new SimpleLayout();
		FileAppender appender = new FileAppender(layout, "BrSU.log", false);
		log.addAppender(appender);
		log.setLevel((Level) Level.DEBUG);
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(st);

			if (result.next()) {
				Vacancy vacancy = new Vacancy();
				vacancy.setSalary(salary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} finally {

			try {
				if (statement != null)
					statement.close();
				if (result != null)
					result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
			ConnectionManager.getConnectorPool().releaseConnection(connection);
		}

		return null;

	}
}
