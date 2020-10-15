package ca.sheridancollege.AMohamed.database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
@Configuration
public class DatabaseConfig {


//create a method to read of the application.properties

// technically the name of the bean is the name of the method its above

//Create and object of this and hold it for later use(i.e injection)// injection at the method level, must go in a class with the @configuration notation
//@component
	
	
 @Bean 
public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
return new NamedParameterJdbcTemplate(dataSource);
}





}
