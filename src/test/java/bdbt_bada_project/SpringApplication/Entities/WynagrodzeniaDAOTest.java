package bdbt_bada_project.SpringApplication.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WynagrodzeniaDAOTest {

    private WynagrodzeniaDAO dao;


    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("bdbtgra11");
        dataSource.setPassword("bdbtgra11");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new WynagrodzeniaDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Wynagrodzenia> wynagrodzeniaList = dao.list();
        System.out.println(wynagrodzeniaList);
        assertTrue(!wynagrodzeniaList.isEmpty());
    }
    @Test
    void save() {
        Wynagrodzenia wynagrodzenia = new Wynagrodzenia(1, "2023-12-23", 5400, 3500, 103);
        dao.save(wynagrodzenia);
    }

    @Test
    void get() {
        int id = 2;
        Wynagrodzenia wynagrodzenia = dao.get(id);
        assertNotNull(wynagrodzenia);
    }

    @Test
    void update() {
        Wynagrodzenia wynagrodzenia = new Wynagrodzenia();
        wynagrodzenia.setId_wynagrodzenia(2);
        wynagrodzenia.setData("2024-01-06");
        wynagrodzenia.setKwota_brutto(7800);
        wynagrodzenia.setKwota_netto(6000);
        wynagrodzenia.setId_pracownika(46);

        dao.update(wynagrodzenia);
    }

    @Test
    void delete() {
        int id = 1;
        dao.delete(id);
    }
}