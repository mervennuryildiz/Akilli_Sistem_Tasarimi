package com.Odev;

import java.sql.SQLException;
import java.util.Random;

public class SogutmaSistemi {
    private IEyleyici eyleyici;
    private IKullanici kullanici;
    private IBildirim bildirim;
    private IGiris giris;

    SicaklikAlgilayici.SingletonEnum singletonEnum = SicaklikAlgilayici.SingletonEnum.SICAKLIK;


    private static final String SICAKLIK_GORUNTULE = "1";
    private static final String SOĞUTUCU_AC = "2";
    private static final String SOGUTUCU_KAPAT = "3";
    private static final String CIKIS = "4";

    private static final String Kontrol="Kontrol";
    private static final String Bekleme="Bekleme";
    private static final String Algılama="Algılama";
    private static final String Kapalı="Kapalı";



    public SogutmaSistemi() {
        eyleyici = new Eyleyici();
        bildirim = new Bildirim();
        giris = new Giris();
        kullanici = new Kullanici("a");
    }

    Random random = new Random();

    public void basla() throws SQLException {
        //Observer
        SicaklikAlgilayici sicaklikBildirimi=new OrtamSıcaklığı();
        Kullanici k1=new Kullanici();
        sicaklikBildirimi.subscribe(new Kullanici(k1.getKullaniciAdi()));
        sicaklikBildirimi.addNewSicaklik(new Temp(" Sıcaklık : "+singletonEnum.getValue()+" derece"));

        islem();
    }
    public boolean sogutucuDurumu = false;
    private void islem() throws SQLException {
        String secim = "0";
        do {
            secim = anaMenuyuGoster();
            switch (secim) {
                case SICAKLIK_GORUNTULE:
                    if (sogutucuDurumu == true) {
                        bildirim.bildirimGoruntule("Sıcaklık = " + singletonEnum.getValue1()+" derece."+
                                System.lineSeparator()+"----------Durum : "+Algılama+"----------");
                    } else
                        bildirim.bildirimGoruntule("Sıcaklık=" + singletonEnum.getValue() + "derece."+
                                System.lineSeparator()+"----------Durum : "+Algılama+"----------");
                    break;
                case SOĞUTUCU_AC:
                    if (sogutucuDurumu == false) {
                        bildirim.bildirimGoruntule("Soğutucu açılıyor..."+
                                System.lineSeparator()+"----------Durum : "+Kontrol+"----------");
                        eyleyici.sogutucuAc();
                    } else
                        bildirim.bildirimGoruntule("Sogutucu açık durumda başka bir seçim yapın."+
                                System.lineSeparator()+"----------Durum : "+Bekleme+"----------");
                    sogutucuDurumu = true;
                    break;
                case SOGUTUCU_KAPAT:
                    if (sogutucuDurumu == true) {
                        bildirim.bildirimGoruntule("Soğutucu kapatılıyor..."+
                                System.lineSeparator()+"----------Durum : "+Kontrol+"----------");
                        eyleyici.sogutucuKapat();
                    } else
                        bildirim.bildirimGoruntule("Sogutucu kapalı başka bir seçim yapın."+
                                System.lineSeparator()+"----------Durum : "+Bekleme+"----------");
                    sogutucuDurumu = false;
                    break;
                case CIKIS:
                    bildirim.bildirimGoruntule("-------ÇIKIŞ YAPILDI-------"+System.lineSeparator()+"--------Durum : "+Kapalı+"--------");
                    System.exit(0);
                default:
                    bildirim.bildirimGoruntule("    YANLIŞ SEÇİM YAPTINIZ TEKRAR DENEYİNİZ      "+
                            System.lineSeparator()+"----------Durum : "+Bekleme+"----------");
            }

        } while (secim != "4");
    }

    private String anaMenuyuGoster() {
        bildirim.bildirimGoruntule("*****************************************");
        bildirim.bildirimGoruntule("Ana Menu");
        bildirim.bildirimGoruntule("1-)Sıcaklık Goruntule");
        bildirim.bildirimGoruntule("2-)Soğutucuyu Ac");
        bildirim.bildirimGoruntule("3-)Sogutucuyu Kapat");
        bildirim.bildirimGoruntule("4-)ÇIKIŞ");
        System.out.print("Seciminiz:");


        return giris.veriAl();
    }

}
