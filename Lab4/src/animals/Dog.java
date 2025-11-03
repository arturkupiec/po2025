package animals;

public class Dog extends Animal {
    public Dog(String name) {
        super(name, 4);
    }


    public String getDescription() {
        return "Pies o imieniu " + name + " ma " + legs + " nogi.";
    }
}