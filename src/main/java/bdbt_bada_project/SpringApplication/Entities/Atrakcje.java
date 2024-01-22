package bdbt_bada_project.SpringApplication.Entities;

public class Atrakcje {
    public int id_atrakcji;
    private String nazwa;
    private char dostepnosc_dzieci;
    private String producer;
    private int liczba_miejsc;
    private String opis;
    private int id_parku;


    public Atrakcje(){

    }

    public Atrakcje(int id, String nazwa, char dostepnosc_dzieci, String producer, int liczba_miejsc, String opis,  int id_parku) {
        super();
        this.id_atrakcji = id;
        this.nazwa = nazwa;
        this.dostepnosc_dzieci = dostepnosc_dzieci;
        this.producer = producer;
        this.liczba_miejsc = liczba_miejsc;
        this.opis = opis;
        this.id_parku = id_parku;
    }

    public int getId_atrakcji() {
        return id_atrakcji;
    }
    public void setId_atrakcji(int id_atrakcji) {
        this.id_atrakcji = id_atrakcji;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public char getDostepnosc_dzieci() {
        return dostepnosc_dzieci;
    }
    public void setDostepnosc_dzieci(char dostepnosc_dzieci) {
        this.dostepnosc_dzieci = dostepnosc_dzieci;
    }

    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public int getLiczba_miejsc() {
        return liczba_miejsc;
    }

    public void setLiczba_miejsc(int liczba_miejsc) {
        this.liczba_miejsc = liczba_miejsc;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getid_parku() {
        return id_parku;
    }

    public void setid_parku(int id_parku) {
        this.id_parku = id_parku;
    }


    @Override
    public String toString() {
        return "Atrakcje{" +
                "id=" + id_atrakcji +
                ", nazwa='" + nazwa + '\'' +
                ", Dostępność dla dzieci='" + dostepnosc_dzieci + '\'' +
                ", Producent=" + producer +
                ", Liczba miejsc='" + liczba_miejsc + '\'' +
                ", Opis='" + opis + '\'' +
                ", Id parku='" + id_parku + '\'' +
                '}';
    }
}
