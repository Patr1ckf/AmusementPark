package bdbt_bada_project.SpringApplication.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttractionsDAOTest {

    private AttractionsDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://aws-0-us-east-1.pooler.supabase.com:6543/postgres");
        dataSource.setUsername("postgres.wxeseejwtrlkyitubugy");
        dataSource.setPassword("dRWMSfNPgGDv3lxk");
        dataSource.setDriverClassName("org.postgresql.Driver");

        dao = new AttractionsDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Attractions> listAttractions = dao.list();
        System.out.println(listAttractions);
        assertTrue(!listAttractions.isEmpty());
    }

    @Test
    void save() {
        Attractions attractions = new Attractions(11, "ANOTHER", "5mins", 5, "baseniki 5 osobowe");
        dao.save(attractions);
    }

    @Test
    void get() {
        int id = 1;
        Attractions attractions = dao.get(id);
        System.out.println(attractions.getDuration());
        assertNotNull(attractions);
    }


    @Test
    void update() {
        Attractions attractions = new Attractions();
        attractions.setId_attraction(11);
        attractions.setName("X");
        attractions.setMin_age(6);
        attractions.setDescription("opis");
        dao.update(attractions);
    }

    @Test
    void delete() {
        int id = 11;
        dao.delete(id);
    }
}