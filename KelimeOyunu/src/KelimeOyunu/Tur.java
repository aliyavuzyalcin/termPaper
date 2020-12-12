package KelimeOyunu;

import java.util.ArrayList;

public class Tur {
    private ArrayList<Kelime> Kelimeler;
    private Oyuncu OynayanYarismaci;

    public Tur(ArrayList<Kelime> kelimeler, Oyuncu oynayanYarismaci) {
        Kelimeler = kelimeler;
        OynayanYarismaci = oynayanYarismaci;
    }
    public void Oyna(){
        for (Kelime kelime:getKelimeler()){
            getOynayanYarismaci().Oyna(kelime);
        }
    }

    public ArrayList<Kelime> getKelimeler() {
        return Kelimeler;
    }

    public void setKelimeler(ArrayList<Kelime> kelimeler) {
        Kelimeler = kelimeler;
    }

    public Oyuncu getOynayanYarismaci() {
        return OynayanYarismaci;
    }

    public void setOynayanYarismaci(Oyuncu oynayanYarismaci) {
        OynayanYarismaci = oynayanYarismaci;
    }



}
