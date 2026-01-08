package org.example.samgui.symulator;

import java.util.ArrayList;
import java.util.List;
import org.example.samgui.Listener;

public class Samochod extends Thread{


        private boolean stanWlaczenia;
        private String nrRejestracji;
        private String model;
        private int predkoscMax;
        private int aktualnaPredkosc;
        private int waga;
        private Silnik silnik;
        private SkrzyniaBiegow skrzynia;
        private Sprzeglo sprzeglo;
        private Pozycja pozycja;
        private Pozycja cel;
        private List<Listener> listeners = new ArrayList<>();


    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }
    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia, Sprzeglo sprzeglo, Pozycja pozycja, String nrRejestracji) {
            this.silnik = silnik;
            this.skrzynia = skrzynia;
            this.sprzeglo = sprzeglo;
            this.pozycja = pozycja;
            this.nrRejestracji = nrRejestracji;
            start();
        }
    //konstruktor do tworzenia samochodu przy funkcji dodajSamochod (pomijamy duzo rzeczy, silnik i skrzynia maja byc wybrame z istniejacej listy :D
    public Samochod(String model, int predkoscMax, int waga, String nrRejestracji, Silnik silnik, SkrzyniaBiegow skrzynia, Pozycja pozycja, Sprzeglo sprzeglo){
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.waga = waga;
        this.nrRejestracji = nrRejestracji;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.sprzeglo = sprzeglo;
        this.pozycja = pozycja;
        start();
    }
        public void wlacz () {
            silnik.uruchom();
            stanWlaczenia = true;
            System.out.println("LODPALILL");
            notifyListeners();
        }
        public void wylacz () {
            silnik.zatrzymaj();
            skrzynia.setAktualnyBieg(0);
            stanWlaczenia = false;
            System.out.println("samochod zgasl ");
            notifyListeners();
        }

        public void jedzDo (Pozycja cel){
            this.cel = cel;}
        public String getNrRejestracji () {
            return this.nrRejestracji;
        }

    public int getWagaSamochodu () {
            return this.silnik.getWaga() + this.skrzynia.getWaga() + this.sprzeglo.getWaga();
        }
        public void zwiekszBieg () {
            if (this.sprzeglo.getStanSprzegla()) {
                this.skrzynia.zwiekszBieg();
                notifyListeners();
            }
        }
        public void zmniejszBieg () {
            if (this.sprzeglo.getStanSprzegla()) {
                this.skrzynia.zmniejszBieg();
                notifyListeners();
            }
        }

        public int obliczPredkosc () {
            int predkosc = (silnik.getObroty() / 100) * skrzynia.getAktualnePrzelozenie();
            return predkosc;
        }

        @Override
        public String toString () {
            return model + " (" + nrRejestracji + ")";
        }
        //====================== gettery do nazw komponentow bo OOP i musi byc w samochodzie bo controler ma dostep TYLKO do samochodu :D :D

        public String getNazwaSprzeglo () {
            return this.sprzeglo.getNazwa();
        }
        public String getNazwaSilnik () {
            return this.silnik.getNazwa();
        }
        public String getNazwaSkrzynia () {
            return this.skrzynia.getNazwa();
        }

        //==================== gettery do cen ==================================
        public int getCenaSprzeglo () {
            return this.sprzeglo.getCena();
        }
        public int getCenaSilnik () {
            return this.silnik.getCena();
        }
        public int getCenaSkrzynia () {
            return this.skrzynia.getCena();
        }

        //==================== gettery do wag ====================================

        public int getWagaSprzeglo () {
            return this.sprzeglo.getWaga();
        }
        public int getWagaSilnik () {
            return this.silnik.getWaga();
        }
        public int getWagaSkrzynia () {
            return this.skrzynia.getWaga();
        }

        //=============== getter do biegu, obrotow, przelozenia, stanu sprzegla
        public int getAktualnyBieg () {
            return this.skrzynia.getAktualnyBieg();
        }
        public int getAktualneObroty () {
            return this.silnik.getObroty();
        }
        public int getAktualnePrzelozenie () {
            return this.skrzynia.getAktualnePrzelozenie();
        }
        public boolean getAktualnyStanSprzegla () {
            return this.sprzeglo.getStanSprzegla();
        }
        public String getStanSprzeglaString () {
            return this.sprzeglo.getStanSprzeglaString();
        }
        //============ zmiana stanu sprzegla
        public void wcisnij () {
            this.sprzeglo.wcisnij();
            notifyListeners();
        }
        public void zwolnij () {
            this.sprzeglo.zwolnij();
            notifyListeners();
        }
        public void zwiekszObroty () {
            this.silnik.zwiekszObroty();
            notifyListeners();
        }
        public void zmniejszObroty () {
            this.silnik.zmniejszObroty();
            notifyListeners();
        }
        //=========== gettery do modelu (na zapas zeby wszystko hulalo)============
        public String getModelSprzeglo () {
            return this.sprzeglo.getModel();}
        public String getModelSilnik () {
            return this.silnik.getModel();
        }
        public String getModelSkrzynia () {
            return this.skrzynia.getModel();
        }
        public void uruchom () {
            this.silnik.uruchom();
            notifyListeners();
        }
        public void zatrzymaj () {
            this.silnik.zatrzymaj();
            notifyListeners();
        }

        //public String toString(){return this.silnik.getModel();}
        public double getX(){return this.pozycja.getX();}
        public double getY(){return this.pozycja.getY();}

    public void run() {
        double deltat = 0.1;
        double epsilon = 0.5;

        while (true) {
            if (cel != null) {
                double dx = cel.getX() - pozycja.getX();
                double dy = cel.getY() - pozycja.getY();
                double dist = Math.sqrt(dx*dx + dy*dy);

                if (dist < epsilon) {
                    pozycja.ustawPozycje(cel.getX(), cel.getY());
                    cel = null;
                    notifyListeners();
                    continue;
                }

                double step = obliczPredkosc() * deltat;
                if (step > dist) step = dist;

                pozycja.aktualizujPozycje(dx / dist * step, dy / dist * step);
                notifyListeners();
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                break;
            }
        }
    }


}


