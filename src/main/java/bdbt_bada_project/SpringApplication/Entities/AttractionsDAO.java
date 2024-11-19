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
public class AttractionsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AttractionsDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Attractions> list(){
        String sql = "SELECT * FROM ATTRACTIONS";
        List<Attractions> attractionsList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Attractions.class));

        return attractionsList;
    }
    // Insert
    public void save(Attractions attractions) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("attractions").
                usingColumns("NAME","DURATION", "MIN_AGE", "DESCRIPTION");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(attractions);
        insertActor.execute(param);
    }

//     Read
    public Attractions get(int id) {
        String sql = "SELECT * FROM ATTRACTIONS WHERE ID_ATTRACTION = ?";
        Object[] args = {id};
        Attractions attractions = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Attractions.class));

        return attractions;
    }

    public Attractions get1(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM ATTRACTIONS WHERE ID_ATTRACTION = " +args[0];
        Attractions attractions = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Attractions.class));

        return attractions;
    }

    // Update
    public void update(Attractions attractions) {
        String sql = "UPDATE ATTRACTIONS SET NAME=:name, DURATION=:duration, MIN_AGE=:min_age, DESCRIPTION=:description" +
                " WHERE ID_ATTRACTION=:id_attraction";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(attractions);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    // Delete
    public void delete(int id) {
        String sql = "DELETE FROM ATTRACTIONS WHERE ID_ATTRACTION = ?";
        jdbcTemplate.update(sql,id);
    }

}
