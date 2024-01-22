package bdbt_bada_project.SpringApplication.Entities;

import bdbt_bada_project.SpringApplication.Entities.Pracownicy;
import bdbt_bada_project.SpringApplication.Entities.PracownicyDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        Pracownicy pracownicy = new Pracownicy(1, "Milena", "Kozłowska", 'K', "1990-01-15", "03323304522",
                                                "milena.koz2@wp.pl", "03344543234323456545454567", 16);
        dao.save(pracownicy);
    }

    @Test
    void testGet() {
        int id = 50;
        Pracownicy pracownicy = dao.get(id);

        assertNotNull(pracownicy);
    }

    @Test
    void testUpdate() {
        Pracownicy pracownicy = new Pracownicy();
        pracownicy.setId_pracownika(50);
        pracownicy.setImie("Patryk");
        pracownicy.setNazwisko("Figiel");
        pracownicy.setPlec('M');
        pracownicy.setData_urodzenia("1998-02-22");
        pracownicy.setPESEL("03402501576");
        pracownicy.setEmail("patryk.f@gmail.com");
        pracownicy.setNumer_konta("03344543234323456545454567");
        pracownicy.setId_parku(16);

        dao.update(pracownicy);
    }

    @Test
    void testDelete() {
        int id = 46;
        dao.delete(id);
    }
}