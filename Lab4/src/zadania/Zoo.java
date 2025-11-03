package zadania;

import animals.*;
import java.util.Random;

public class Zoo {
    private Animal[] animals = new Animal[100];
    private Random random = new Random();

    public Zoo() {
        fillZoo();
    }

    private void fillZoo() {
        for (int i = 0; i < animals.length; i++) {
            int type = random.nextInt(3); // 0 = Dog, 1 = Parrot, 2 = Snake
            switch (type) {
                case 0 -> animals[i] = new Dog("pieskolnikow" + i);
                case 1 -> animals[i] = new Parrot("papunia" + i);
                case 2 -> animals[i] = new Snake("megaWaz" + i);
            }
        }
    }

    public int countAllLegs() {
        int sum = 0;
        for (Animal a : animals) {
            sum += a.getLegs();
        }
        return sum;
    }

    public void printAnimals() {
        for (Animal a : animals) {
            System.out.println(a.getDescription());
        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.printAnimals();
        System.out.println("Suma nóg wszystkich zwierząt: " + zoo.countAllLegs());
    }
}