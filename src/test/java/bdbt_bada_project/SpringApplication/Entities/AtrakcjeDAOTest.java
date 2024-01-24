package bdbt_bada_project.SpringApplication.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AtrakcjeDAOTest {

    private AtrakcjeDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("bdbtgra11");
        dataSource.setPassword("bdbtgra11");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AtrakcjeDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Atrakcje> listAtrakcje = dao.list();
        System.out.println(listAtrakcje);
        assertTrue(!listAtrakcje.isEmpty());
    }

    @Test
    void save() {
        Atrakcje atrakcje = new Atrakcje(46, "ANOTHER", "Waterex", 5, "baseniki 5 osobowe", 16);
        dao.save(atrakcje);
    }

    @Test
    void get() {
        int id = 187;
        Atrakcje atrakcje = dao.get(id);
        System.out.println(atrakcje.getProducent());
        assertNotNull(atrakcje);
    }


    @Test
    void update() {
        Atrakcje atrakcje = new Atrakcje();
        atrakcje.setId_atrakcji(51);
        atrakcje.setNazwa("X");
        atrakcje.setLiczba_miejsc(6);
        atrakcje.setOpis("opis");
        atrakcje.setId_parku(16);
        dao.update(atrakcje);
    }

    @Test
    void delete() {
        int id = 186;
        dao.delete(id);
    }
}