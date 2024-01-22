package bdbt_bada_project.SpringApplication.Entities;

public class Pracownicy {
    public int id_pracownika;
    private String imie;
    private String nazwisko;
    private char plec;
    private String data_urodzenia;
    private String PESEL;
    private String email;
    private String numer_konta;
    private int id_parku;

    public Pracownicy(){

    }

    public Pracownicy(int id, String name, String nazwisko, char gender, String dateOfBirth, String PESEL, String email, String bankAccount, int id_parku) {
        super();
        this.id_pracownika = id;
        this.imie = name;
        this.nazwisko = nazwisko;
        this.plec = gender;
        this.data_urodzenia = dateOfBirth;
        this.PESEL = PESEL;
        this.email = email;
        this.numer_konta = bankAccount;
        this.id_parku = id_parku;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public String getData_urodzenia() {
        if(data_urodzenia == null){
            return data_urodzenia;
        }
        else {
            return data_urodzenia.substring(0, 10);
        }
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumer_konta() {
        return numer_konta;
    }

    public void setNumer_konta(String numer_konta) {
        this.numer_konta = numer_konta;
    }

    public int getId_parku() {
        return id_parku;
    }

    public void setId_parku(int id_parku) {
        this.id_parku = id_parku;
    }

    @Override
    public String toString() {
        return "Pracownicy{" +
                "id=" + id_pracownika +
                ", name='" + imie + '\'' +
                ", lastName='" + nazwisko + '\'' +
                ", gender=" + plec +
                ", dateOfBirth='" + data_urodzenia + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", email='" + email + '\'' +
                ", bankAccount='" + numer_konta + '\'' +
                '}';
    }
}
