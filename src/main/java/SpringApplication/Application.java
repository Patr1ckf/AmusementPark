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
		String databaseUrl = System.getenv("SUPABASE_DB_URL");
		// Upewnij się, że masz ustawioną zmienną środowiskową na Heroku

		// Sprawdzamy, czy URL zaczyna się od 'postgres://', jeśli tak, zamieniamy to na 'jdbc:postgresql://'
		if (databaseUrl != null && databaseUrl.startsWith("postgres://")) {
			databaseUrl = databaseUrl.replace("postgres://", "jdbc:postgresql://");
		}

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(databaseUrl);  // Ustawiamy URL bazy danych
		dataSource.setDriverClassName("org.postgresql.Driver");  // Ustawiamy sterownik PostgreSQL

		return dataSource;
	}






	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
