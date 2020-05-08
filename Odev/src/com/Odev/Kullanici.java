package com.Odev;

import java.sql.SQLException;

public class Kullanici implements IKullanici {

    private IGiris giris;
    private IBildirim bildirim;

    private String kullaniciAdi;
    private String sifre;

    public Kullanici(String isim) {

        giris = new Giris();
        bildirim = new Bildirim();
    }
    public Kullanici() {
        giris=new Giris();
        bildirim=new Bildirim();

    }
    DataBase d1 = new DataBase();
    public void kullaniciDogrula() throws SQLException {
        bildirim.bildirimGoruntule("*********LÜTFEN GİRİŞ YAPINIZ*********");
        bildirim.bildirimGoruntule("Lütfen kullanıcı adınızı girin");
        kullaniciAdi = giris.veriAl();
        bildirim.bildirimGoruntule("Lütfen şifrenizi girin");
        sifre = giris.veriAl();
    }
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
    public String getSifre() {
        return sifre;
    }

    @Override
    public void update(SicaklikAlgilayici sicaklikAlgilayici) {
        bildirim.bildirimGoruntule(String.format(" Sıcaklık : %s derece ", sicaklikAlgilayici.getMsicaklik()));
    }

}
