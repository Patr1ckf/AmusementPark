package SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        // Pobieramy zmienne środowiskowe
        String dbUrl = System.getenv("SUPABASE_DB_URL");  // Upewnij się, że zmienne są prawidłowo ustawione
        String username = System.getenv("SUPABASE_DB_USERNAME");
        String password = System.getenv("SUPABASE_DB_PASSWORD");

        // Sprawdzamy, czy zmienne są ustawione
        if (dbUrl == null || username == null || password == null) {
            throw new IllegalArgumentException("Database connection details are missing.");
        }

        // Tworzymy i konfigurujemy DataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("org.postgresql.Driver");

        return dataSource;
    }
}
