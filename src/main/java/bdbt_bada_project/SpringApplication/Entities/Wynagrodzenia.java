package bdbt_bada_project.SpringApplication.Entities;

public class Wynagrodzenia {

    private int id_wynagrodzenia;
    private String data;
    private int kwota_brutto;
    private int kwota_netto;
    private int id_pracownika;

    public Wynagrodzenia(){

    }

    public Wynagrodzenia(int id_wynagrodzenia, String data, int kwota_brutto, int kwota_netto, int id_pracownika) {
        super();
        this.id_wynagrodzenia = id_wynagrodzenia;
        this.data = data;
        this.kwota_brutto = kwota_brutto;
        this.kwota_netto = kwota_netto;
        this.id_pracownika = id_pracownika;
    }

    public int getId_wynagrodzenia() {
        return id_wynagrodzenia;
    }

    public void setId_wynagrodzenia(int id_wynagrodzenia) {
        this.id_wynagrodzenia = id_wynagrodzenia;
    }

    public String getData() {
        if(data == null){
            return data;
        }
        else {
            return data.substring(0, 10);
        }    }

    public void setData(String data) {
        this.data = data;
    }

    public int getKwota_brutto() {
        return kwota_brutto;
    }

    public void setKwota_brutto(int kwota_brutto) {
        this.kwota_brutto = kwota_brutto;
    }

    public int getKwota_netto() {
        return kwota_netto;
    }

    public void setKwota_netto(int kwota_netto) {
        this.kwota_netto = kwota_netto;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    @Override
    public String toString() {
        return "Wynagrodzenia{" +
                "id_wynagrodzenia=" + id_wynagrodzenia +
                ", data='" + data + '\'' +
                ", kwota_brutto='" + kwota_brutto + '\'' +
                ", kwota_netto='" + kwota_netto + '\'' +
                ", id_pracownika=" + id_pracownika +
                '}';
    }
}
