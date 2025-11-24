package org.example.samgui.symulator;

public class Pozycja {

    private double x;
    private double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void aktualizujPozycje(double d_x, double d_y) {
        this.x += d_x;
        this.y += d_y;
    }

    public String getPozycja(){
        return "x: " +  this.x + " y: " + this.y;
    }

    public double getX(){return this.x;}
    public double getY(){return this.y;}
}
