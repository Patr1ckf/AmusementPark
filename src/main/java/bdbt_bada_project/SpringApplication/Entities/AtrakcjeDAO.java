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
public class AtrakcjeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AtrakcjeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Atrakcje> list(){
        String sql = "SELECT * FROM ATRAKCJE";

        List<Atrakcje> AtrakcjeList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Atrakcje.class));
        return AtrakcjeList;
    }
    // Insert – wstawianie nowego wiersza do bazy
    public void save(Atrakcje atrakcje) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("atrakcje").usingColumns("id_atrakcji", "nazwa", "dostępność_dla_dzieci","producent",
                "liczba_miejsc", "opis", "id_parku");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(atrakcje);
        insertActor.execute(param);
    }

    // Read – odczytywanie danych z bazy
    public Atrakcje get(int id) {
        String sql = "SELECT * FROM ATRAKCJE WHERE ID_ATRAKCJI = ?";
        Object[] args = {id};
        Atrakcje atrakcje = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Atrakcje.class));
        return atrakcje;
    }

    public Atrakcje get1(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM ATRAKCJE WHERE ID_ATRAKCJI = " +args[0];
        Atrakcje atrakcje = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Atrakcje.class));
        return atrakcje;
    }

    // Update – aktualizacja danych
    public void update(Atrakcje atrakcje) {
        String sql = "UPDATE ATRAKCJE SET NAZWA=:nazwa, PRODUCENT=:producent, DOSTEPNOSC_DLA_DZIECI=:dostępność_dla_dzieci," +
                "     LICZBA_MIEJSC=:liczba_miejsc, OPIS=:opis, ID_PARKU=:id_parku" +
                " WHERE ID_ATRAKCJI=:id_atrakcji";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(atrakcje);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    // Delete – wybrany rekord z danym id
    public void delete(int id) {
        String sql = "DELETE FROM ATRAKCJE WHERE ID_ATRAKCJI = ?";
        jdbcTemplate.update(sql,id);
    }

}
