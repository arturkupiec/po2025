package org.example.samgui.symulator;

public class SkrzyniaBiegow extends Komponent{

    private int iloscBiegow;
    private int aktualnyBieg;
    private int aktualnePrzelozenie;

    public SkrzyniaBiegow(String producent, String model, int iloscBiegow){
        super(producent, model);
        this.iloscBiegow = iloscBiegow;
        this.aktualnyBieg = 0;
    }
    public void zwiekszBieg(){
        if (aktualnyBieg < iloscBiegow){
            aktualnyBieg++;
            System.out.println("teraz jest bieg: " + aktualnyBieg);
        }else {
            System.out.println("nie da sie wyzszego biegu :( ");
        }
    }
    public void zmniejszBieg(){
        if(aktualnyBieg > 0){
            aktualnyBieg--;
            System.out.println("teraz jest bieg: " + aktualnyBieg);
        } else {
            System.out.println("nie da sie nizszego biegu :/");
        }
    }
    public void setAktualnyBieg(int bieg){
        this.aktualnyBieg = bieg;
    }
}
