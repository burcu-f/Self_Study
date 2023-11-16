package CalisanlarProgrami;

public class Yazilimci extends Calisan {

    String bildigiDiller;

    public Yazilimci(String ad, String soyad, int id, String bildigiDiller) {
        super(ad, soyad, id);
        this.bildigiDiller = bildigiDiller;
    }
    public void formatAt(String isletimSistemi) {
        System.out.println(getAd() + " " + getSoyad() + " " + isletimSistemi + " yüklüyor...");
    }

    @Override
    public void bilgileriGoster() {
        super.bilgileriGoster();
        System.out.println("Bildiği Programlama Dilleri: " + bildigiDiller);
    }
}
