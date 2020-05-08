package com.Odev;

import java.util.Scanner;

public class Giris implements IGiris{

    public String veriAl() {
        Scanner input=new Scanner(System.in);
        return input.next();
    }
}
