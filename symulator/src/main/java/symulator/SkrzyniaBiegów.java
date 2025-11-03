package symulator;

public class SkrzyniaBiegów extends Komponent{

    private int iloscBiegow;
    private int aktualnyBieg;
    private int aktualnePrzelozenie;

    public void zwiekszBieg(){
        if (aktualnyBieg >= iloscBiegow){
            break;
        }else {
            aktualnyBieg++;
        }
    }
    public void zmniejszBieg(){
        if(aktualnyBieg <= 0){
            break;
        }else{
            aktualnyBieg--;
        }
    }
}
