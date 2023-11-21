package SehirTuruProgrami;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void islemleriBastir() {
        System.out.println("0 - İşlemleri Görüntüle");
        System.out.println("1 - Bir Sonraki Şehre Git");
        System.out.println("2 - Bir Önceki Şehre Git");
        System.out.println("3 - Uygulamadan Çık");
    }
    public static void sehirleriTurla (LinkedList<String> sehirler) {
        ListIterator<String> iterator = sehirler.listIterator();

        int islem;

        islemleriBastir();

        Scanner scanner = new Scanner(System.in);

        if (!iterator.hasNext()) {
            System.out.println("Herhangi bir şehir bulunamadı...");
        }

        boolean cikis = false;
        boolean ileri = true;

        while (!cikis) {
            System.out.println("Bir işlem seçiniz: ");
            islem = scanner.nextInt();

            switch (islem) {
                case 0:
                    islemleriBastir();
                    break;

                case 1:
                    System.out.println("Şehir turu başlıyor...");
                    if (!ileri) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }

                        ileri = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Şehre gidiliyor: " + iterator.next());
                    }
                    else {
                        System.out.println("Gidilecek şehir kalmadı...");
                        ileri = true;
                    }
                    break;

                case 2:
                    if (ileri){
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }

                        ileri = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Şehre gidiliyor: " + iterator.previous());
                    }
                    else {
                        System.out.println("Şehir turu başladı...");
                    }
                    break;

                case 3:
                    cikis = true;
                    System.out.println("Uygulamadan çıkılıyor...");
                    break;

            }
        }





    }
    public static void main(String[] args) {
        LinkedList <String> sehirler = new LinkedList<String>();
        sehirler.add("Ankara");
        sehirler.add("İzmir");
        sehirler.add("Ordu");
        sehirler.add("Mardin");

        sehirleriTurla(sehirler);


    }
}
