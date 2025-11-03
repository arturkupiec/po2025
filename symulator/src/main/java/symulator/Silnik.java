package symulator;

public class Silnik extends Komponent{

    private int maxObroty;
    private int obroty;

    public void uruchom(){};
    public void zatrzymaj(){};
    public void zwiekszObroty(){};
    public void zmniejszObroty(){};

    public Silnik(String producent, String model) {
        super(producent, model);
    }

    public Silnik(int maxObroty, int obroty, String producent, String model){
        super(producent, model);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
    }

}
