package symulator;

public class Main {
    public static void main(String[] args) {
        Silnik silnik = new Silnik(5000, 0, "FSO", "poldek");
        SkrzyniaBiegów skrzynia = new SkrzyniaBiegów("FSO","poldek", 5);
        Sprzęgło sprzeglo = new Sprzęgło("FSO", "poldek", false);
        Pozycja pozycja = new Pozycja(0, 0);

        Samochód poldek = new Samochód(silnik, skrzynia, sprzeglo, pozycja);

        poldek.wlacz();
        poldek.skrzynia.zwiekszBieg();
        poldek.jedzDo(pozycja, new Pozycja(10, 10));
        poldek.wylacz();
    }
}
