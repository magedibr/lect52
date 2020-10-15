package ca.sheridancollege.AMohamed.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;



import ca.sheridancollege.AMohamed.beans.Student;




@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
// insert the student frank into the DB	
	public void insertStudent() {
		
		//used to specify parameters
				MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			
				//Specific query
			//	String query ="INSERT INTO student(name) VALUES ('Frank')";
				
				//insert Student to DB
				//int rowsAffected= jdbc.update(query, namedParameters);
				
				//if(rowsAffected >0) {
				//System.out.println("Student inserted");
				//}
		
	}
	
	//insert the name entered by the user
	public void insertStudent(Student student) {
		
		
		
		//used to specify parameters
				MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			
				//Specific query
				String query ="INSERT INTO student(name) VALUES (:name)";
				
				//specify the name
				namedParameters.addValue("name", student.getName());
				
				
				//insert Student to DB
				int rowsAffected= jdbc.update(query, namedParameters);
				
				if(rowsAffected >0) {
				System.out.println("Student inserted");
				}
		
		
		
		
	}
	
	public List<Student> getStudentList(){
		
		//To use for parameter
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM student";
		
	
		
		//Converts the rows that are fetched from the sudent to student objects so that can they be shown on the html 
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
		
		
		
		
	}
	
	
public void deleteStudentById(Long ID)	{
	
		
	
	MapSqlParameterSource namedParameters = new MapSqlParameterSource();

	
	
   //Query//Must be the same as sd the addVAlue for the named parameter below
	String querey = "DELETE FROM student WHERE id = :id";
	
	
	// Specify the value of the names parameter
//"id"
	namedParameters.addValue("id", ID);
	
     //Perform delete
	
	int rowsAffected = jdbc.update(querey, namedParameters);
	
	if(rowsAffected >0)System.out.println("Student with id"+ID+"has been deleted");
	

	
	
}	
public List<Student> getStudentListById(Long ID) {

MapSqlParameterSource namedParameters = new MapSqlParameterSource();

String query = "SELECT * FROM student WHERE id = :id";


//Value to replace the named parameter
namedParameters.addValue("id", ID);


//Return the list matching the query
return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));

}	
	
























}
