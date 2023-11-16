package CalisanlarProgrami;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Çalışanlar Programına Hoşgeldiniz...");
        String islemler = "İşlemler\n"
                + "1. Yazılımcı İşlemleri\n"
                + "2. Yönetici İşlemleri\n"
                + "Çıkış için q'ya basın.";
        System.out.println(islemler);

        while (true) {
            System.out.print("İşlem seçiniz: ");
            String islem = scanner.nextLine();

            if (islem.equals("q")) {
                System.out.println("Programdan çıkılıyor...");
                break;
            } else if (islem.equals("1")) {

                String yazIslemler = "Yazılımcı İşlemleri\n"
                        + "1. Format At\n"
                        + "2. Bilgileri Göster\n"
                        + "Çıkış için q'ya basın.";
                System.out.println(yazIslemler);

                while (true) {
                    System.out.print("İşlem seçiniz: ");
                    String yazIslem = scanner.nextLine();

                    Yazilimci yazilimci = new Yazilimci("Jane", "Doe", 1, "Java");

                    if (yazIslem.equals("q")) {
                        System.out.println("Programdan çıkılıyor...");
                        break;
                    } else if (yazIslem.equals("1")) {
                        System.out.println("İşletim Sistemini Girin: ");
                        String isletimSistemi = scanner.nextLine();
                        yazilimci.formatAt(isletimSistemi);

                    } else if (yazIslem.equals("2")) {
                        yazilimci.bilgileriGoster();
                    } else {
                        System.out.println("Geçersiz işlem! Tekrar deneyin.");
                    }
                }

            } else if (islem.equals("2")) {
                String yonIslemler = "Yönetici İşlemleri\n"
                        + "1. Zam Yap\n"
                        + "2. Bilgileri Göster\n"
                        + "Çıkış için q'ya basın.";
                System.out.println(yonIslemler);

                while (true) {
                    System.out.print("İşlem seçiniz: ");
                    String yonIslem = scanner.nextLine();

                    Yonetici yonetici = new Yonetici("Mary", "Smith", 2, 10);

                    if (yonIslem.equals("q")) {
                        System.out.println("Programdan çıkılıyor...");
                        break;

                    }
                    else if (yonIslem.equals("1")) {
                        System.out.println("Uygulamak İstediğiniz Zam Miktarını Girin: ");
                        int zamMiktari = scanner.nextInt();
                        scanner.nextLine();
                        yonetici.zamYap(zamMiktari);

                    }
                    else if (yonIslem.equals("2")) {
                        yonetici.bilgileriGoster();
                    }

                    else {
                        System.out.println("Geçersiz işlem! Tekrar deneyin.");
                    }

                }

            } else{
                System.out.println("Geçersiz işlem! Tekrar deneyin.");
            }
        }
    }
}
