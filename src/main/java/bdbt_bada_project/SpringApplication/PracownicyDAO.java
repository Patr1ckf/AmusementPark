package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownicy> list(){
        String sql = "SELECT * FROM PRACOWNICY";

        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }
    // Insert – wstawianie nowego wiersza do bazy
    public void save(Pracownicy sale) {
    }

    // Read – odczytywanie danych z bazy
    public Pracownicy get(int id) {
        return null;
    }

    // Update – aktualizacja danych
    public void update(Pracownicy sale) {
    }

    // Delete – wybrany rekord z danym id
    public void delete(int id) {
    }

}
