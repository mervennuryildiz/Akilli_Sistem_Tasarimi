package com.Odev;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Bildirim bildirim = new Bildirim();
        Kullanici k1 = new Kullanici();
        k1.kullaniciDogrula();
        DataBase d1 = new DataBase();
        if (d1.girisYap(k1.getKullaniciAdi(), k1.getSifre()) == true) {
            bildirim.bildirimGoruntule1("HOŞGELDİN " + k1.getKullaniciAdi() +
                    " Saat : " + LocalTime.now().getHour() +
                    "." + LocalTime.now().getMinute());
            SogutmaSistemi ss = new SogutmaSistemi();
            ss.basla();
        }

    }
}
