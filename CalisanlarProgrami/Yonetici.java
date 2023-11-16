package CalisanlarProgrami;

public class Yonetici extends Calisan {

    int sorumluKisi;

    public Yonetici(String ad, String soyad, int id, int sorumluKisi) {
        super(ad, soyad, id);
        this.sorumluKisi = sorumluKisi;
    }

    @Override
    public void bilgileriGoster() {
        super.bilgileriGoster();
        System.out.println("Yöneticinin Sorumlu Olduğu Kişi Sayısı: " + sorumluKisi);
    }

    public void zamYap(int zamMiktari) {
        System.out.println(getAd() + " " + getSoyad() + " çalışanlara " + zamMiktari + " tl zam yaptı." );
    }
}
