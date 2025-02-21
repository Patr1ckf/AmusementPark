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
//		dataSource.setUrl("jdbc:postgresql://aws-0-us-east-1.pooler.supabase.com:6543/postgres");
//		dataSource.setUsername("postgres.wxeseejwtrlkyitubugy");
//		dataSource.setPassword("dRWMSfNPgGDv3lxk");
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		return dataSource;
//	}

	@Bean
	public DataSource dataSource() {
		String databaseUrl = System.getenv("DATABASE_URL");

		if (databaseUrl != null && databaseUrl.startsWith("postgres://")) {
			// Zamiana "postgres://" na "jdbc:postgresql://"
			databaseUrl = databaseUrl.replace("postgres://", "jdbc:postgresql://");
		}

		// Inicjalizacja DataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(databaseUrl);  // Ustawienie URL
		dataSource.setUsername("postgres");  // Ustawienie użytkownika (możesz pobrać z URL)
		dataSource.setPassword("dRWMSfNPgGDv3lxk");  // Ustawienie hasła (możesz pobrać z URL)
		dataSource.setDriverClassName("org.postgresql.Driver");  // Ustawienie klasy sterownika

		return dataSource;
	}




	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
