package org.example.samgui.symulator;

public class Sprzeglo extends Komponent{

    private boolean stanSprzegla;

    public Sprzeglo(String producent, String model, boolean stanSprzegla) {
        super(producent, model);
        this.stanSprzegla = false;
    }

    public void wcisnij(){
        stanSprzegla = true;
        System.out.println("sprzeglo wcisniete :D");
    }
    public void zwolnij(){
        stanSprzegla = false;
        System.out.println("sprzeglo zwolnione :D");
    }
    public boolean stanSprzegla(){return stanSprzegla;}

}
