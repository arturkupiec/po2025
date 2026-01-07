package org.example.samgui.symulator;

public class Sprzeglo extends Komponent{

    private boolean stanSprzegla;
    private String standardowaNazwa = "default_sprzeglo";


    public Sprzeglo(String producent, String model) {
        super(producent, model);
        this.stanSprzegla = false;
    }

    public Sprzeglo(String producent, String model, boolean stanSprzegla, int cena, int waga, String nazwa) {
        super(producent, model, cena, waga, nazwa);
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
    public boolean getStanSprzegla(){return stanSprzegla;}

    public String getStanSprzeglaString() {
        return stanSprzegla ? "Wciśnięte" : "Zwolnione";
    }

}
