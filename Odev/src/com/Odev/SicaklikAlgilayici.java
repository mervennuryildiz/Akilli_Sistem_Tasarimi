package com.Odev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private List<IKullanici> kullaniciList;
    private List<Integer> sicakliklar;
    private Temp msicaklik;

    {
        kullaniciList = new ArrayList<IKullanici>();
        sicakliklar = new ArrayList<Integer>();
    }

    public void subscribe(IKullanici kullanici) {
        kullaniciList.add(kullanici);
    }

    public void unsubscribe(IKullanici kullanici) {
        kullaniciList.remove(kullanici);
    }
    public void notifyChanges() {
        for (IKullanici kullanici : kullaniciList) {
            kullanici.update(this);
        }
    }

    Random rnd = new Random();

    public enum SingletonEnum {
        SICAKLIK;
        int derece;

        public int getValue() {
            Random rnd = new Random();
            derece = rnd.nextInt(35);
            if (derece < 20) {
                while (derece < 20) {
                    derece = rnd.nextInt(35);
                }
                return derece;
            } else {

                return derece;
            }
        }

        public int getValue1() {
            Random rnd = new Random();
            derece = rnd.nextInt(21);
            return derece;
        }
    }

    SingletonEnum singletonEnum = SingletonEnum.SICAKLIK;



    public String toString() {
        return "sıcaklık=" + singletonEnum.derece + '}';
    }

    public int getMsicaklik() {
        return this.singletonEnum.derece;
    }

    public void addNewSicaklik(Temp sicaklik) {
        sicakliklar.add((Integer) singletonEnum.derece);
        this.msicaklik = sicaklik;
        notifyChanges();

    }

}
