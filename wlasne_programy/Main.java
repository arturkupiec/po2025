import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Osoba pawel = new Osoba();
        pawel.name = "Krzysztof";
        pawel.age = 18;
        pawel.isAlive = true;

        Osoba dominik = new Osoba();
        dominik.name = "Kononowicz";
        dominik.age = 54;
        dominik.isAlive = false; // [*]

        String pawelsiewita = pawel.przedstawSie(true);
        System.out.println(dominik.przedstawSie(false));
        System.out.println(pawelsiewita);

        String pawelsiewita1 = pawel.przedstawSie(true);
        String pawelsiewita2 = pawel.przedstawSie(true);

        int ileRazy = Osoba.ilePrzedstawionoLiczba();

        System.out.println("Przedstawily sie " + ileRazy + " osob :D");

        int[][] tab = {{1,3,2}, {3, 2, 1,}, {0,2}};
        System.out.println(tab);
        int max = 7;
        int min = 1;
        Random r = new Random();
        int dzienTyogdnia = r.nextInt(7) + 1;
        System.out.println(dzienTyogdnia);

        switch(dzienTyogdnia){
            default:
                System.out.println("cos poszlo nie tak");
                break;
            case 1:
                System.out.println("PONIEDZIALEK AUUUU");
                break;
            case 2:
                System.out.println("WTOREK AUUUU");
                break;
            case 3:
                System.out.println("SRODA AUUUU");
                break;
            case 4:
                System.out.println("CZWARTEK AUUUU");
                break;
            case 5:
                System.out.println("PIATEK AUUUU");
                break;
            case 6:
                System.out.println("SOBOTA AUUUU");
                break;
            case 7:
                System.out.println("NIEDZIELA AUUUU");
                break;
        }

        dominik.porownajZ10();
    }   



}
