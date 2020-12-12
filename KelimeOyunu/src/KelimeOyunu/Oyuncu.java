package KelimeOyunu;

import java.util.Scanner;

public class Oyuncu extends Kisi {
    private int toplamPuan;

    public Oyuncu(String adSoyad) {
        super(adSoyad);
        this.toplamPuan = 0;
    }
    public void Oyna(Kelime kelime){
        Scanner sc = new Scanner(System.in);
    while(!kelime.bulunduMu()){
        System.out.println("Toplam Puanınız: "+getToplamPuan());
        System.out.println(kelime.getSoru());
        System.out.println("  "+kelime.getIcerik());
        System.out.print("Tahmininiz(Harf almak için 1):");
        String Tahmin = sc.nextLine();
        if (Tahmin.equals("1")){
            kelime.harfAl();
        }
        else{
            if (kelime.tahminEt(Tahmin)){
                System.out.print("Tebrikler! +"+kelime.getPuanDegeri()+" puan kazandınız\n");
                toplamPuan+=kelime.getPuanDegeri();
                break;
            }
        }
    }
    }

    public int getToplamPuan() {
        return toplamPuan;
    }

    public void setToplamPuan(int toplamPuan) {
        this.toplamPuan = toplamPuan;
    }



}
