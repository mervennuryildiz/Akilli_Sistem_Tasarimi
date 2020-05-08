package com.Odev;

import java.sql.SQLException;

public interface IKullanici {

    public void kullaniciDogrula() throws SQLException;
    public String getKullaniciAdi();
    public String getSifre();
    void update(SicaklikAlgilayici sicaklikAlgilayici);
}
