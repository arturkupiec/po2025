package animals;

public class Parrot extends Animal{
    public Parrot(String name){
        super(name, 2);
    }

    public String getDescription() {
        return "papuszka o imieniu " + name + " ma " + legs + " nogi.";
    }
}
