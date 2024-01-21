package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.beans.BeanProperty;
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

        List<Pracownicy> pracownicyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicyList;
    }
    // Insert – wstawianie nowego wiersza do bazy
    public void save(Pracownicy pracownicy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("id_pracownika", "imie", "nazwisko","plec",
                "data_urodzenia", "PESEL", "email","numer_konta", "id_parku");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        insertActor.execute(param);
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
