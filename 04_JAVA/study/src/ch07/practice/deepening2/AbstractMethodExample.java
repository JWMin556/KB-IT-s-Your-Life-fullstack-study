package ch07.practice.deepening2;

public class AbstractMethodExample {
    public static void animalSound(Animal animal) {
        animal.sound();
    }
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        animalSound(new Dog());
        animalSound(new Cat());
    }
}
