package bdbt_bada_project.SpringApplication.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalariesDAOTest {

    private SalariesDAO dao;


    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://aws-0-us-east-1.pooler.supabase.com:6543/postgres");
        dataSource.setUsername("postgres.wxeseejwtrlkyitubugy");
        dataSource.setPassword("dRWMSfNPgGDv3lxk");
        dataSource.setDriverClassName("org.postgresql.Driver");

        dao = new SalariesDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Salaries> salariesList = dao.list();
        System.out.println(salariesList);
        assertTrue(!salariesList.isEmpty());
    }
    @Test
    void save() {
        Salaries salaries = new Salaries(11, "2023-12-23", 5400, 3500, 0);
        dao.save(salaries);
    }

    @Test
    void get() {
        int id = 4;
        Salaries salaries = dao.get(id);
        assertNotNull(salaries);
    }

    @Test
    void update() {
        Salaries salaries = new Salaries();
        salaries.setId_salary(11);
        salaries.setDate("2024-01-06");
        salaries.setGross_salary(7800);
        salaries.setNet_salary(100);
        salaries.setId_employee(167);

        dao.update(salaries);
    }

    @Test
    void delete() {
        int id = 11;
        dao.delete(id);
    }
}