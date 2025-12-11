package org.example.samgui.symulator;

public class Samochod {

    private boolean stanWlaczenia;
    private String nrRejestracji;
    private String model;
    private int predkoscMax;

    public Silnik silnik;
    public SkrzyniaBiegow skrzynia;
    public Sprzeglo sprzeglo;
    public Pozycja pozycja;

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia, Sprzeglo sprzeglo, Pozycja pozycja, String nrRejestracji){
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.sprzeglo = sprzeglo;
        this.pozycja = pozycja;
        this.nrRejestracji = nrRejestracji;
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
    public String getNrRejestracji(){return this.nrRejestracji;}
    public void setNrRejestracji(String nrRejestracji){this.nrRejestracji = nrRejestracji;}


}
