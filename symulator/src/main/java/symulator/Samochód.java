package symulator;

public class Samochód {

    private boolean stanWlaczenia;
    private String nrRejestracji;
    private String model;
    private int predkoscMax;

    private Silnik silnik;
    public SkrzyniaBiegów skrzynia;
    private Sprzęgło sprzeglo;
    private Pozycja pozycja;

    public Samochód(Silnik silnik, SkrzyniaBiegów skrzynia, Sprzęgło sprzeglo, Pozycja pozycja){
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.sprzeglo = sprzeglo;
        this.pozycja = pozycja;

    }

    public void wlacz(){
        silnik.uruchom();
        stanWlaczenia = true;
        System.out.println("LODPALILL");
    }
    public void wylacz(){
        silnik.zatrzymaj();
        skrzynia.setAktualnyBieg(0);
        stanWlaczenia = false;
        System.out.println("samochod zgasl ");
    }

    public void jedzDo(Pozycja pozycja, Pozycja cel){
        double deltaX = cel.getX() - pozycja.getX();
        double deltaY = cel.getY() - pozycja.getY();

        pozycja.aktualizujPozycje(deltaX, deltaY);
        System.out.println("dojechalimy do " + pozycja.getPozycja());
    }



}
