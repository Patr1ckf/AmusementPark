package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;

class PracownicyDAOTest {

    private PracownicyDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("bdbtgra11");
        dataSource.setPassword("bdbtgra11");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PracownicyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testList() {
        List<Pracownicy> listPracownicy = dao.list();
        assertTrue(!listPracownicy.isEmpty());
    }

    @Test
    void testSave() {
    }

    @Test
    void testGet() {
    }

    @Test
    void testUpdate() {
    }

    @Test
    void testDelete() {
    }
}