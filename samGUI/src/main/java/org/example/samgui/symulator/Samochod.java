package org.example.samgui.symulator;

import java.sql.SQLOutput;

public class Samochod {

    private boolean stanWlaczenia;
    private String nrRejestracji;
    private String model;
    private int predkoscMax;
    private int aktualnaPredkosc;

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

    public int getWagaSamochodu(){
        return this.silnik.getWaga() + this.skrzynia.getWaga() + this.sprzeglo.getWaga();
    }
    public void zwiekszBieg(){
        if (this.sprzeglo.getStanSprzegla()){
            this.skrzynia.zwiekszBieg();
        }
    }
    public void zmniejszBieg(){
        if(this.sprzeglo.getStanSprzegla()){
            this.skrzynia.zmniejszBieg();
        }
    }

    public int obliczPredkosc() {
        int predkosc = (silnik.getObroty() / 100) * skrzynia.getAktualnePrzelozenie();
        return predkosc;
    }

    @Override
    public String toString() {
        return model + " (" + nrRejestracji + ")";
    }
}
