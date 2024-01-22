package bdbt_bada_project.SpringApplication.Entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WynagrodzeniaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WynagrodzeniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wynagrodzenia> list(){
        String sql = "SELECT * FROM WYNAGRODZENIA";

        List<Wynagrodzenia> wynagrodzeniaList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
        return wynagrodzeniaList;
    }
    // Insert – wstawianie nowego wiersza do bazy
    public void save(Wynagrodzenia wynagrodzenia) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("wynagrodzenia").
                usingColumns("DATA", "KWOTA_BRUTTO", "KWOTA_NETTO", "ID_PRACOWNIKA");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenia);
        insertActor.execute(param);
    }

    // Read – odczytywanie danych z bazy
    public Wynagrodzenia get(int id) {
        String sql = "SELECT * FROM WYNAGRODZENIA WHERE ID_WYNAGRODZENIA = ?";
        Object[] args = {id};
        Wynagrodzenia wynagrodzenia = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
        return wynagrodzenia;
    }

    public Wynagrodzenia get1(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM WYNAGRODZENIA WHERE ID_WYNAGRODZENIA = " +args[0];
        Wynagrodzenia wynagrodzenia = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
        return wynagrodzenia;
    }

    // Update – aktualizacja danych
    public void update(Wynagrodzenia wynagrodzenia) {
        String sql = "UPDATE WYNAGRODZENIA SET DATA=:data, KWOTA_BRUTTO=:kwota_brutto, KWOTA_NETTO=:kwota_netto, ID_PRACOWNIKA=:id_pracownika WHERE ID_WYNAGRODZENIA=:id_wynagrodzenia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    // Delete – wybrany rekord z danym id
    public void delete(int id) {
        String sql = "DELETE FROM WYNAGRODZENIA WHERE ID_WYNAGRODZENIA = ?";
        jdbcTemplate.update(sql,id);
    }
}
