package com.Odev;

import java.sql.*;

public class DataBase {
    private IBildirim bildirim;

    public DataBase() {
        bildirim=new Bildirim();
    }


    public Connection baglan() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Nesne",
                    "postgres", "2980147.Merve");
            if (conn != null)
                bildirim.bildirimGoruntule("Veritabanına bağlanıyor...");
            else
                bildirim.bildirimGoruntule("Bağlantı girişimi başarısız!");
        } catch (SQLException e) {
        }
        return conn;
    }

    public boolean girisYap(String kullanici_adi, String sifre) throws SQLException {
        Connection conn = baglan();
        String sql = "SELECT * FROM \"public\".\"kullanici\" WHERE \"kullaniciAdi\" = '" +
                    kullanici_adi + "'and sifre = '" + sifre + "'";
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                conn.close();
                if (rs.next()) {
                    bildirim.bildirimGoruntule("Kullanıcı bilgileri doğrulandı. ");
                    return true;
                } else {
                    bildirim.bildirimGoruntule("Hatalı giriş! Kullanıcı adı veya şifre yanlış.");
                    return false;
                }
            } catch (SQLException e) {
            }
        } else
            return false;
        return false;
    }
}
