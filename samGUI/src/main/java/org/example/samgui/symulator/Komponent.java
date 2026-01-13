package org.example.samgui.symulator;

public abstract class Komponent {

    private String producent;
    private String model;
    private int cena;
    private int waga;
    private String nazwa;
    public String getProducent() {return producent;}

    public String getModel() {return model;}

    public Komponent(String producent, String model) {
        this.model = model;
        this.producent = producent;
    }
    public Komponent(String producent, String model, int cena, int waga, String nazwa) {
        this.model = model;
        this.producent = producent;
        this.cena = cena;
        this.waga = waga;
        this.nazwa = nazwa;
    }

    public String getNazwa(){return this.nazwa;}
    public void setNazwa(String nazwa){this.nazwa = nazwa;}

    public int getCena(){return this.cena;}
    public void setCena(int cena){this.cena = cena;}

    public int getWaga(){return this.waga;}
    public void setWaga(int waga){this.waga = waga;}

    public Komponent(Komponent inny){
        this.producent = inny.producent;
        this.waga = inny.waga;
        this.model = inny.model;
        this.cena = inny.cena;
        this.nazwa = inny.nazwa;

    }



}
