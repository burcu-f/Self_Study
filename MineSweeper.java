import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private static final char emptyCell = '-';

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz!");
        System.out.print("Satır sayısını girin: ");
        int satir = scanner.nextInt();

        System.out.print("Sütun sayısını girin: ");
        int sutun = scanner.nextInt();

        int mayinSayisi = (satir * sutun) / 4;
        char[][] oyunTahtasi = new char[satir][sutun];
        char[][] gosterilenTahta = new char[satir][sutun];

        baslangicTahtasiniAyarla(oyunTahtasi);
        mayinlariYerlestir(oyunTahtasi, mayinSayisi);

        boolean oyunDevamEdiyor = true;

        while (oyunDevamEdiyor) {
            oyunTahtasiniGoster(gosterilenTahta);

            System.out.print("Satır girin: ");
            int secilenSatir = scanner.nextInt();

            System.out.print("Sütun girin: ");
            int secilenSutun = scanner.nextInt();

            oyunDevamEdiyor = oyunuOyna(oyunTahtasi, gosterilenTahta, secilenSatir, secilenSutun);

            if (!oyunDevamEdiyor) {
                oyunuSonlandir(gosterilenTahta, oyunTahtasi);
            }
        }

        scanner.close();
    }

    private static void baslangicTahtasiniAyarla(char[][] tahta) {
        for (int i = 0; i < tahta.length; i++) {
            for (int j = 0; j < tahta[i].length; j++) {
                tahta[i][j] = '-';
            }
        }
    }

    private static void mayinlariYerlestir(char[][] tahta, int mayinSayisi) {
        Random random = new Random();

        for (int i = 0; i < mayinSayisi; i++) {
            int satir = random.nextInt(tahta.length);
            int sutun = random.nextInt(tahta[0].length);

            while (tahta[satir][sutun] == '*') {
                satir = random.nextInt(tahta.length);
                sutun = random.nextInt(tahta[0].length);
            }

            tahta[satir][sutun] = '*';
        }
    }

    private static void oyunTahtasiniGoster(char[][] tahta) {
        System.out.println("Mayın Tarlası Oyunu:");
        for (char[] row : tahta) {
            for (char cell : row) {
                System.out.print((cell == '\u0000') ? emptyCell + " " : cell + " ");
            }
            System.out.println();
        }
    }

    private static boolean oyunuOyna(char[][] oyunTahtasi, char[][] gosterilenTahta, int satir, int sutun) {
        if (satir < 0 || satir >= oyunTahtasi.length || sutun < 0 || sutun >= oyunTahtasi[0].length) {
            System.out.println("Geçersiz bir konum girdiniz. Tekrar deneyin.");
            return true;
        }

        if (oyunTahtasi[satir][sutun] == '*') {
            System.out.println("Mayına bastınız! Oyun bitti.");
            return false;
        }

        int mayinSayisi = komsuMayinSayisiniHesapla(oyunTahtasi, satir, sutun);
        gosterilenTahta[satir][sutun] = (char) (mayinSayisi + '0');

        if (mayinSayisi == 0) {
            oyunuGenislet(oyunTahtasi, gosterilenTahta, satir, sutun);
        }

        return true;
    }

    private static int komsuMayinSayisiniHesapla(char[][] tahta, int satir, int sutun) {
        int mayinSayisi = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int yeniSatir = satir + i;
                int yeniSutun = sutun + j;

                if (yeniSatir >= 0 && yeniSatir < tahta.length && yeniSutun >= 0 && yeniSutun < tahta[0].length) {
                    if (tahta[yeniSatir][yeniSutun] == '*') {
                        mayinSayisi++;
                    }
                }
            }
        }

        return mayinSayisi;
    }

    private static void oyunuGenislet(char[][] oyunTahtasi, char[][] gosterilenTahta, int satir, int sutun) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int yeniSatir = satir + i;
                int yeniSutun = sutun + j;

                if (yeniSatir >= 0 && yeniSatir < oyunTahtasi.length && yeniSutun >= 0 && yeniSutun < oyunTahtasi[0].length) {
                    if (gosterilenTahta[yeniSatir][yeniSutun] == '-') {
                        oyunuOyna(oyunTahtasi, gosterilenTahta, yeniSatir, yeniSutun);
                    }
                }
            }
        }
    }

    private static void oyunuSonlandir(char[][] gosterilenTahta, char[][] oyunTahtasi) {
        System.out.println("Mayınların Konumu:");
        oyunTahtasiniGoster(oyunTahtasi);

        System.out.println("Oyunu Kaybettiniz!");
    }
}
