package lotto_v2;

import java.util.Random;
import java.util.ArrayList;


public class Lotto_c_d{
    public static void main(String[] args){
        ArrayList<Integer> podane = new ArrayList<>();

        for (int i = 0; i < 6; i++){
            podane.add(Integer.parseInt(args[i]));
        }
        ArrayList<Integer> lista = new ArrayList<>();
        int max = 49, min = 1;
        Random rand = new Random();
        while (lista.size() < 6){
            boolean czy_powtarza = false;

            int liczba = rand.nextInt(max - min + 1) + min;

            for (int i = 0; i < lista.size(); i++){
                if (lista.get(i) == liczba){
                    czy_powtarza = true;
                    break;
                }
            }
            if (czy_powtarza == false){
                lista.add(liczba);
            }
        }
        int liczba_trafien = 0;
        for (int i = 0; i < lista.size(); i++){
            for (int j = 0; j < lista.size(); j++){
                if (podane.get(j) == lista.get(i)){
                    liczba_trafien++;
                }
            }


        }

        System.out.println("podane typy          " + podane);
        System.out.println("wylosowane liczby    " + lista);
        System.out.println("liczba trafien:      " + liczba_trafien);


    }
}