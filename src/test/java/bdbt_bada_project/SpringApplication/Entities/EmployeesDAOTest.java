package bdbt_bada_project.SpringApplication.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeesDAOTest {

    private EmployeesDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://aws-0-us-east-1.pooler.supabase.com:6543/postgres");
        dataSource.setUsername("postgres.wxeseejwtrlkyitubugy");
        dataSource.setPassword("dRWMSfNPgGDv3lxk");
        dataSource.setDriverClassName("org.postgresql.Driver");

        dao = new EmployeesDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testSave() {
        Employees employees = new Employees(11, "Milena", "Kozłowska", 'K', "1990-01-15", "03323304522",
                "milena.koz2@wp.pl", "03344543234323456545454567");
        dao.save(employees);
    }

    @Test
    void testList() {
        List<Employees> listEmpleyees = dao.list();
        assertTrue(!listEmpleyees.isEmpty());
    }

    @Test
    void testGet() {
        int id = 0;
        Employees employees = dao.get(id);

        assertNotNull(employees);
    }

    @Test
    void testUpdate() {
        Employees employees = new Employees();
        employees.setId_employee(11);
        employees.setName("Patryk");
        employees.setSurname("Figiel");
        employees.setGender('M');
        employees.setBirth_date("1998-02-22");
        employees.setPersonal_id("03402501576");
        employees.setEmail("patryk.f@gmail.com");
        employees.setBank_account("03344543234323456545454567");
        dao.update(employees);
    }

    @Test
    void testDelete() {
        int id = 11;
        dao.delete(id);
    }
}