import java.util.Random;

public class Lotto{
    public static void main(String[] args){
        int[] lista = new int[6]; 
        int ilosc_wylosowanych = 0;
        int max = 49, min = 1;
        Random rand = new Random();
        //plan jest taki zeby najpierw wylosowac liczbe POTEM sprawdzic czy sie nei powtarza A NA KONCU ja dodac
        while (ilosc_wylosowanych < 6){
            boolean czy_powtarza = false;
            
            int liczba = rand.nextInt(max - min + 1) + min;
            
            for (int i = 0; i < ilosc_wylosowanych; i++){
                if (lista[i] == liczba){
                    czy_powtarza = true;
                    break;
                }
            }
            if (czy_powtarza == false){
                lista[ilosc_wylosowanych] = liczba;
                ilosc_wylosowanych++;
            }


        }
        //wyswietlam elegancko wyniki juz poprawne
        for(int i = 0; i < 6; i++){
            System.out.print(lista[i]);
            System.out.print(",");
        }

    }
}