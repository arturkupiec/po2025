package animals;

public class Snake extends Animal{
    public Snake(String name) {
        super(name, 0);
    }

    public String getDescription() {
        return "waz o imieniu " + name + " ma " + legs + " nogi.";
    }
}
