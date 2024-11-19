package bdbt_bada_project.SpringApplication.Entities;

public class Employees {
    public int id_employee;
    private String name;
    private String surname;
    private char gender;
    private String birth_date;
    private String personal_id;
    private String email;
    private String bank_account;

    public Employees(){
    }

    public Employees(int id, String name, String surname, char gender, String dateOfBirth, String personal_id, String email, String bankAccount) {
        super();
        this.id_employee = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birth_date = dateOfBirth;
        this.personal_id = personal_id;
        this.email = email;
        this.bank_account = bankAccount;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBirth_date() {
        if(birth_date == null){
            return birth_date;
        }
        else {
            return birth_date.substring(0, 10);
        }
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id_employee +
                ", name='" + name + '\'' +
                ", lastName='" + surname + '\'' +
                ", gender=" + gender +
                ", dateOfBirth='" + birth_date + '\'' +
                ", personal_id='" + personal_id + '\'' +
                ", email='" + email + '\'' +
                ", bankAccount='" + bank_account + '\'' +
                '}';
    }
}
