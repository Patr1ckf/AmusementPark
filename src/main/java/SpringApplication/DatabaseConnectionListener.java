package SpringApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionListener implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    private final JdbcTemplate jdbcTemplate;

    public DatabaseConnectionListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Attempting to connect to: " + datasourceUrl);
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("Connection to the database was successful!");
        } catch (Exception e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}
