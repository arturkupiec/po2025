package org.example.samgui.symulator;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Silnik silnik = new Silnik(5000, 0, "FSO", "polonez");
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("FSO","polonez", 5);
        Sprzeglo sprzeglo = new Sprzeglo("FSO", "polonez", false);
        Pozycja pozycja = new Pozycja(0, 0);

        Samochod poldek = new Samochod(silnik, skrzynia, sprzeglo, pozycja);

        poldek.wlacz();
        poldek.skrzynia.zwiekszBieg();
        poldek.jedzDo(pozycja, new Pozycja(10, 10));
        poldek.wylacz();
        System.out.println(poldek.skrzynia.getModel());
    }
}
