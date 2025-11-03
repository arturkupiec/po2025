package symulator;

public class Sprzęgło extends Komponent{


    public Sprzęgło(String producent, String model, int stanSprzegla) {
        super(producent, model);
        this.stanSprzegla = stanSprzegla;
    }

    private int stanSprzegla;
    public void wcisnij(){
        stanSprzegla = 1;
    }
    public void zwolnij(){
        stanSprzegla = 0;
    }

}
