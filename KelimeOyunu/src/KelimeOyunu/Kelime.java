package KelimeOyunu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Kelime implements IKomutlar{
    private String icerik;
    private String soru;
    private int puanDegeri;
    private ArrayList<Boolean> bulunanHarfler;

    public Kelime(String icerik, String soru) {
        this.icerik = icerik;
        this.soru = soru;
        this.puanDegeri = icerik.length()*100;
        this.bulunanHarfler = new ArrayList<Boolean>();
        for(int i=0;i<icerik.length();i++){
            bulunanHarfler.add(false);
        }
    }
    public boolean bulunduMu(){
    for (Boolean harf:bulunanHarfler){
        if(harf==false)return false;
    }
    return true;
    }
    public void harfAl(){
        Random rnd = new Random();
        int index;
        do{
            index=rnd.nextInt(icerik.length());
        }while(bulunanHarfler.get(index));
        bulunanHarfler.set(index,true);
        puanDegeri-=100;
    }
    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    @Override
    public boolean tahminEt(String tahmin){
        if (this.icerik.equals(tahmin.toUpperCase()))return true;
        else return false;
    }
    public String getIcerik() {
        StringBuilder gizliKelime = new StringBuilder(icerik);
        for (int i=0;i<bulunanHarfler.size();i++){
            if (bulunanHarfler.get(i)==false){
                gizliKelime.setCharAt(i,'*');
            }
        }
        return gizliKelime.toString();
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public int getPuanDegeri() {
        return puanDegeri;
    }

    public void setPuanDegeri(int puanDegeri) {
        this.puanDegeri = puanDegeri;
    }

    public ArrayList<Boolean> getBulunanHarfler() {
        return bulunanHarfler;
    }

    public void setBulunanHarfler(ArrayList<Boolean> bulunanHarfler) {
        this.bulunanHarfler = bulunanHarfler;
    }


}
