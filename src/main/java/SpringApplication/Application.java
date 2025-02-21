package SpringApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUrl("jdbc:postgresql://aws-0-us-east-1.pooler.supabase.com:5432/postgres");
//		dataSource.setUsername("postgres.wxeseejwtrlkyitubugy");
//		dataSource.setPassword("dRWMSfNPgGDv3lxk");
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		return dataSource;
//	}
@Bean
public DataSource dataSource() {
	// Pobieramy zmienne środowiskowe z Heroku
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	String dbUrl = System.getenv("SUPABASE_URL");
	String dbUsername = System.getenv("SUPABASE_DB_USERNAME");
	String dbPassword = System.getenv("SUPABASE_DB_PASSWORD");

	dataSource.setUrl(dbUrl);
	dataSource.setUsername(dbUsername);
	dataSource.setPassword(dbPassword);

	return dataSource;
}



	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
