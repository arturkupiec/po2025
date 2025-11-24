package org.example.samgui.symulator;

public abstract class Komponent {

    private String producent;
    private String model;

    public String getProducent() {return producent;}

    public String getModel() {return model;}

    public Komponent(String producent, String model) {
        this.model = model;
        this.producent = producent;
    }

}
