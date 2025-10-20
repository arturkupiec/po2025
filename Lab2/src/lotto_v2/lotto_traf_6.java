package lotto_v2;

import java.util.Random;
import java.util.ArrayList;

public class lotto_traf_6 {
    public static void main(String[] args) {
        ArrayList<Integer> wygrywajace = new ArrayList<>();
        Random rand = new Random();
        int max = 49, min = 1;

        while (wygrywajace.size() < 6) {
            boolean czy_powtarza = false;
            int wylosowana = rand.nextInt(max - min + 1) + min;

            for (int i = 0; i < wygrywajace.size(); i++) {
                if (wygrywajace.get(i) == wylosowana) {
                    czy_powtarza = true;
                    break;
                }
            }

            if (!czy_powtarza) {
                wygrywajace.add(wylosowana);
            }
        }
        System.out.println("Liczby wygrywające: " + wygrywajace);

        int liczba_trafien = 0;
        long start_prob = System.currentTimeMillis();
        ArrayList<Integer> typowane = new ArrayList<>();
        int liczba_prob = 0;


        while (liczba_trafien != 6) {
            liczba_trafien = 0;


            typowane.clear();
            while (typowane.size() < 6) {
                boolean czy_powtarza = false;
                int typowana = rand.nextInt(max - min + 1) + min;

                for (int i = 0; i < typowane.size(); i++) {
                    if (typowane.get(i) == typowana) {
                        czy_powtarza = true;
                        break;
                    }
                }

                if (!czy_powtarza) {
                    typowane.add(typowana);
                }
            }

            for (int i = 0; i < typowane.size(); i++) {
                if (wygrywajace.contains(typowane.get(i))) {
                    liczba_trafien++;
                }
            }

            liczba_prob++;
        }

        long end_prob = System.currentTimeMillis();
        long duration = end_prob - start_prob; // Czas w milisekundach


        System.out.println("Typowane liczby: " + typowane);
        System.out.println("Liczba trafień: " + liczba_trafien);
        System.out.println("Liczba prób: " + liczba_prob);
        System.out.println("Czas wykonania: " + duration);
    }
}