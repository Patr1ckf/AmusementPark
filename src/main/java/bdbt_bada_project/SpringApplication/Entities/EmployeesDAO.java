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
public class EmployeesDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmployeesDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employees> list(){
        String sql = "SELECT * FROM EMPLOYEES";

        List<Employees> employeesList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employees.class));
        for (Employees employee : employeesList) {
            System.out.println(employee.toString());
        }
        return employeesList;
    }
    // Insert
    public void save(Employees employees) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("employees").usingColumns("id_employee", "name", "surname","gender",
                "birth_date", "personal_id", "email","bank_account");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employees);
        insertActor.execute(param);
    }

    // Read
    public Employees get(int id) {
        String sql = "SELECT * FROM EMPLOYEES WHERE ID_EMPLOYEE = ?";
        Object[] args = {id};
        return jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Employees.class));
    }

    public Employees get1(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM EMPLOYEES WHERE ID_EMPLOYEE = " +args[0];
        return jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Employees.class));
    }

    // Update
    public void update(Employees employees) {
        String sql = "UPDATE EMPLOYEES SET NAME=:name, SURNAME=:surname, GENDER=:gender," +
                "     BIRTH_DATE=:birth_date, PERSONAL_ID=:personal_id, EMAIL=:email, BANK_ACCOUNT=:bank_account" +
                " WHERE ID_EMPLOYEE=:id_employee";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employees);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    // Delete
    public void delete(int id) {
        String sql = "DELETE FROM EMPLOYEES WHERE ID_EMPLOYEE = ?";
        String sql2 = "DELETE FROM SALARIES WHERE ID_EMPLOYEE = ?";
        jdbcTemplate.update(sql2,id);
        jdbcTemplate.update(sql,id);
    }
}
