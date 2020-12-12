import java.util.ArrayList;
import KelimeOyunu.*;
public class Test {

    public static void main(String[] args) {

        ArrayList<Oyuncu> Yarismacilar = new ArrayList<Oyuncu>();
        Yarismacilar.add(new Oyuncu("Ali Tarık Hekimoğlu"));
        //Yarismacilar.add(new Oyuncu("Gül Kaçmaz"));
        Oyun oyun = new Oyun(Yarismacilar, "src\\KelimeOyunu\\kelimeler.txt");
        oyun.Basla();

    }
}
