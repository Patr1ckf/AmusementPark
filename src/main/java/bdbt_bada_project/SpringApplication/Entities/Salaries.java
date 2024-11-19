package bdbt_bada_project.SpringApplication.Entities;

public class Salaries {

    private int id_salary;
    private String date;
    private int gross_salary;
    private int net_salary;
    private int id_employee;

    public Salaries(){
    }

    public Salaries(int id_salary, String date, int gross_salary, int net_salary, int id_employee) {
        super();
        this.id_salary = id_salary;
        this.date = date;
        this.gross_salary = gross_salary;
        this.net_salary = net_salary;
        this.id_employee = id_employee;
    }

    public int getId_salary() {
        return id_salary;
    }

    public void setId_salary(int id_salary) {
        this.id_salary = id_salary;
    }

    public String getDate() {
        if(date == null){
            return date;
        }
        else {
            return date.substring(0, 10);
        }    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGross_salary() {
        return gross_salary;
    }

    public void setGross_salary(int gross_salary) {
        this.gross_salary = gross_salary;
    }

    public int getNet_salary() {
        return net_salary;
    }

    public void setNet_salary(int net_salary) {
        this.net_salary = net_salary;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    @Override
    public String toString() {
        return "Salaries{" +
                "id_salary=" + id_salary +
                ", date='" + date + '\'' +
                ", gross_salary='" + gross_salary + '\'' +
                ", net_salary='" + net_salary + '\'' +
                ", id_employee=" + id_employee +
                '}';
    }
}
