import java.util.Random;
import java.util.ArrayList;


public class Lotto_c_d{
    public static void main(String[] args){
        
        
        //for (int i = 0; i < 6; i++){
        //    System.out.print(args[i]);
        //    System.out.print(',');
        //}

        ArrayList<Integer> wskazane = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++){
            wskazane.add(Integer.parseInt(args[i]));
        }
        System.out.println(wskazane);
        ArrayList<Integer> lista = new ArrayList<Integer>(6); 
        Int ilosc_wylosowanych = 0;
        Integer max = 49, min = 1;
        Random rand = new Random();
        while (ilosc_wylosowanych < 6){
            boolean czy_powtarza = false;
            Integer liczba = rand.nextInt(max - min + 1) + min;
            
            for (int i = 0; i < ilosc_wylosowanych; i++){
                if (lista.get(i) == liczba){
                    czy_powtarza = true;
                    break;
                }
            }
            if (czy_powtarza == false){
                lista.add(ilosc_wylosowanych) = liczba;
                ilosc_wylosowanych++;
            }


        }
        for(int i = 0; i < 6; i++){
            System.out.print(lista.get(i));
            System.out.print(",");
        }

    }
}