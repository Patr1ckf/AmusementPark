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
        String sql = "SELECT * FROM PRACOWNICY WHERE ID_PRACOWNIKA = ?";
        Object[] args = {id};
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }

    public Pracownicy get1(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM PRACOWNICY WHERE ID_PRACOWNIKA = " +args[0];
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }

    // Update – aktualizacja danych
    public void update(Pracownicy pracownicy) {
        String sql = "UPDATE PRACOWNICY SET IMIE=:imie, NAZWISKO=:nazwisko, PLEC=:plec," +
                "     DATA_URODZENIA=:data_urodzenia, PESEL=:PESEL, EMAIL=:email, NUMER_KONTA=:numer_konta, ID_PARKU=:id_parku" +
                " WHERE ID_PRACOWNIKA=:id_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    // Delete – wybrany rekord z danym id
    public void delete(int id) {
        String sql = "DELETE FROM PRACOWNICY WHERE ID_PRACOWNIKA = ?";
        String sql2 = "DELETE FROM WYNAGRODZENIA WHERE ID_PRACOWNIKA = ?";
        jdbcTemplate.update(sql2,id);
        jdbcTemplate.update(sql,id);
    }

}
