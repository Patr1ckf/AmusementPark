package bdbt_bada_project.SpringApplication.Entities;

public class Atrakcje {

    public int id_atrakcji;
    private String nazwa;
    private String producent;
    private int liczba_miejsc;
    private String opis;
    private int id_parku;

    public Atrakcje(){

    }

    public Atrakcje(int id, String nazwa, String producent, int liczba_miejsc, String opis,  int id_parku) {
        super();
        this.id_atrakcji = id;
        this.nazwa = nazwa;
        this.producent = producent;
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

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
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

    public int getId_parku() {
        return id_parku;
    }

    public void setId_parku(int id_parku) {
        this.id_parku = id_parku;
    }

    @Override
    public String toString() {
        return "Atrakcje{" +
                "id_atrakcji=" + id_atrakcji +
                ", nazwa='" + nazwa + '\'' +
                ", producent='" + producent + '\'' +
                ", liczba_miejsc=" + liczba_miejsc +
                ", opis='" + opis + '\'' +
                ", id_parku=" + id_parku +
                '}';
    }
}
