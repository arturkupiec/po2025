package org.example.samgui.symulator;

public class Silnik extends Komponent{

    private int maxObroty;
    private int obroty;

    public Silnik(int maxObroty, int obroty, String producent, String model){
        super(producent, model);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
    }

    public Silnik(int maxObroty, int obroty, String producent, String model, int cena, int waga, String nazwa){
        super(producent, model, cena, waga, nazwa);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
    }

    public void uruchom(){
        this.obroty = 1000;
        System.out.println("teraz mozna elegancko jechac obroty wynosza: " + this.obroty);
    }
    public void zatrzymaj(){
        this.obroty = 0;
        System.out.println("silnik elegancko zatrzymany");
    }
    public void zwiekszObroty(){
        if (this.obroty < maxObroty){
            this.obroty += 500;
            System.out.println("teraz silnik ma elegancko " + this.obroty + " obrotow :D");
        }else{
            System.out.println("wiecej obrotow nie pojdzie :( ");
        }
    }
    public void zmniejszObroty(){
        if (this.obroty > 0){
            this.obroty -= 500;
            System.out.println("teraz silnik ma elegancko " + this.obroty + " obrotow");
        } else {
            System.out.println("nie no nie da sie mniej");
        }
    }

    public int getObroty(){return this.obroty;}
    public void setObroty(int obroty){this.obroty = obroty;}


}
