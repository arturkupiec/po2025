package symulator;

public class Sprzęgło extends Komponent{

    private boolean stanSprzegla;

    public Sprzęgło(String producent, String model, boolean stanSprzegla) {
        super(producent, model);
        this.stanSprzegla = false;
    }

    public void wcisnij(){
        stanSprzegla = true;
        System.out.println("sprzeglo wcisniete :D");
    }
    public void zwolnij(){
        stanSprzegla = false;
        System.out.println("sprzeglo zwolnione :D");
    }
    public boolean stanSprzegla(){return stanSprzegla;}

}
