package org.example.samgui.symulator;

public class Main {
    public static void main(String[] args) {
        Silnik silnik = new Silnik(5000, 0, "FSO", "poldek");
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("FSO","poldek", 5);
        Sprzeglo sprzeglo = new Sprzeglo("FSO", "poldek", false);
        Pozycja pozycja = new Pozycja(0, 0);

        Samochod poldek = new Samochod(silnik, skrzynia, sprzeglo, pozycja);

        poldek.wlacz();
        poldek.skrzynia.zwiekszBieg();
        poldek.jedzDo(pozycja, new Pozycja(10, 10));
        poldek.wylacz();
    }
}
