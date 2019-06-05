public class Test {
  public static void main(String[] args) {
    // Animal animal1 = new Animal();
    Fish animal3 = new Fish();
    Fox fox = new Fox(5);
    Dog dog = new Dog();

    Parrot parrot = new Parrot();
    Trainer trainer = new Trainer();
    Human human = new Human();
    // animal.numberOfLegs = 4;

    // animal1.setNumberOfLegs(4);

    System.out.println(String.format("The number of legs for animal 3 is %d", animal3.getNumberOfLegs()));
    // System.out.println(animal1.getNumberOfLegs());

    System.out.println(fox.getType());
    // System.out.println(animal1.getType());

    System.out.println(dog.getType());

    dog.makeSound();
    fox.makeSound();

    trainer.train(parrot);
    trainer.train(human);
  }
}