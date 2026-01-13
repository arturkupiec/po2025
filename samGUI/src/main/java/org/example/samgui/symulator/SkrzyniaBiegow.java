package org.example.samgui.symulator;

public class SkrzyniaBiegow extends Komponent{

    private int iloscBiegow;
    private int aktualnyBieg;
    private int aktualnePrzelozenie;
    private final int[] przelozenia = {0, 10, 8, 6, 4, 2};



    public SkrzyniaBiegow(String producent, String model, int iloscBiegow){
        super(producent, model);
        this.iloscBiegow = iloscBiegow;
        this.aktualnyBieg = 0;
    }

    public SkrzyniaBiegow(String producent, String model, int iloscBiegow, int cena, int waga, String nazwa){
        super(producent, model, cena, waga, nazwa);
        this.iloscBiegow = iloscBiegow;
        this.aktualnyBieg = 0;
    }

    public SkrzyniaBiegow(SkrzyniaBiegow skrzynia){
        super(skrzynia);
        this.aktualnyBieg = 0;
        this.iloscBiegow = skrzynia.iloscBiegow;
        this.aktualnePrzelozenie = skrzynia.aktualnePrzelozenie;
    }
    public void zwiekszBieg(){
        if (aktualnyBieg < iloscBiegow){
            aktualnyBieg++;
            aktualnePrzelozenie = przelozenia[aktualnyBieg];
            System.out.println("teraz jest bieg: " + aktualnyBieg);
        }else {
            System.out.println("nie da sie wyzszego biegu :( ");
        }
    }
    public void zmniejszBieg(){
        if(aktualnyBieg > 0){
            aktualnyBieg--;
            aktualnePrzelozenie = przelozenia[aktualnyBieg];
            System.out.println("teraz jest bieg: " + aktualnyBieg);
        } else {
            System.out.println("nie da sie nizszego biegu :/");
        }
    }
    public void setAktualnyBieg(int bieg){this.aktualnyBieg = bieg;}

    public int getAktualnyBieg(){return this.aktualnyBieg;}

    public int getAktualnePrzelozenie(){return this.aktualnePrzelozenie;}
    public String toString(){return getNazwa();}



}

