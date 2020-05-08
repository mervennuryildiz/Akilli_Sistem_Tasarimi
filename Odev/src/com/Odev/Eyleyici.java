package com.Odev;

import java.time.LocalTime;
import java.util.Random;

public class Eyleyici implements IEyleyici {
    SicaklikAlgilayici.SingletonEnum singletonEnum= SicaklikAlgilayici.SingletonEnum.SICAKLIK;

    private IBildirim bildirim;

    public Eyleyici() {
        bildirim=new Bildirim();
    }

    public void sogutucuAc() {
        bildirim.bildirimGoruntule("Sogutucu Acıldı...  Saat :"+ LocalTime.now().getHour()+"."+LocalTime.now().getMinute());
    }

    public void sogutucuKapat() {
        Random random=new Random();
        bildirim.bildirimGoruntule("Sogutucu Kapatıldı...   Saat : "+LocalTime.now().getHour()+"."+LocalTime.now().getMinute()
                                    +"  Son sıcaklık : "+ singletonEnum.getValue1()+" derece");
    }

}
