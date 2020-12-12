package KelimeOyunu;

import java.util.ArrayList;

public class Kategori {
    private String kategori;
    private ArrayList<Kelime> Kelimeler;

    public Kategori(String kategori) {
        this.kategori = kategori;
        Kelimeler = new ArrayList<Kelime>();
    }
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public ArrayList<Kelime> getKelimeler() {
        return Kelimeler;
    }

    public void setKelimeler(ArrayList<Kelime> kelimeler) {
        Kelimeler = kelimeler;
    }

}
