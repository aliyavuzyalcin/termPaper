package KelimeOyunu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Oyun {
    private ArrayList<Oyuncu> Yarismacilar;
    private ArrayList<Kategori> Kategoriler;

    public Oyun(ArrayList<Oyuncu> yarismacilar,String dosyaAdi) {
        Yarismacilar = yarismacilar;
        Kategoriler = new ArrayList<Kategori>();
        DosyadanOku(dosyaAdi);
    }
    public Kategori rastgeleKategori(){
        Random rnd = new Random();
        return getKategoriler().get(rnd.nextInt(getKategoriler().size()));
    }
    public void Basla(){
        for (Oyuncu o:getYarismacilar()){
            Kategori rastgele = rastgeleKategori();
            System.out.println("Tur başladı. Kategoriniz:"+rastgele.getKategori());
            Tur yeniTur = new Tur(rastgele.getKelimeler(),o);
            yeniTur.Oyna();
            System.out.println(o.getAdSoyad()+" Adlı yarismacinin toplam puani: "+o.getToplamPuan());
        }
        DosyayaKaydet();
    }

    private void DosyayaKaydet() {
        try {
            FileWriter fileWriter = new FileWriter("SonYarisma.txt");
            for (Oyuncu o:getYarismacilar()){
                fileWriter.write(
                        o.getAdSoyad()+" Aldığı Puan: "+o.getToplamPuan()+"\n"
                );
            }
            fileWriter.close();
            System.out.println("Yarismaci bilgileri kaydedildi.");
        } catch (IOException e) {
            System.out.println("Bir hata olustu.");
            e.printStackTrace();
        }
 
    }

    public int kategoriVarmi(String kategori){
    for (Kategori k : getKategoriler()){
        if (k.getKategori().equals(kategori)){
            return getKategoriler().indexOf(k);
        }
    }
    return -1;
    }
    private void DosyadanOku(String dosyaAdi){
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(dosyaAdi));
            String satir = bufferedReader.readLine();
            while (satir != null) {
                //Satır formatı: <kategori>:<soru>:<kelime>
                String par[]=satir.toUpperCase().split(":");
                int kategoriIndex = kategoriVarmi(par[0]);
                if(kategoriIndex!=-1){
                    getKategoriler().get(kategoriIndex).getKelimeler().add(new Kelime(par[2],par[1]));
                }
                else{
                    Kategori yeniKategori = new Kategori(par[0]);
                    yeniKategori.getKelimeler().add(new Kelime(par[2],par[1]));
                    getKategoriler().add(yeniKategori);
                }
                satir = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Oyuncu> getYarismacilar() {
        return Yarismacilar;
    }

    public void setYarismacilar(ArrayList<Oyuncu> yarismacilar) {
        Yarismacilar = yarismacilar;
    }

    public ArrayList<Kategori> getKategoriler() {
        return Kategoriler;
    }

    public void setKategoriler(ArrayList<Kategori> kategoriler) {
        Kategoriler = kategoriler;
    }
}
