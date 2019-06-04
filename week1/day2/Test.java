public class Test {
  public static void main(String[] args) {
    Animal animal1 = new Animal();
    Animal animal3 = new Animal("Fish");
    Animal animal2 = new Animal(5, "Fox");
    Dog dog = new Dog();
    // animal.numberOfLegs = 4;

    animal1.setNumberOfLegs(4);

    System.out.println(String.format("The number of legs for animal 3 is %d", animal3.getNumberOfLegs()));
    System.out.println(animal1.getNumberOfLegs());

    System.out.println(animal2.getType());
    System.out.println(animal1.getType());

    System.out.println(dog.getType());
  }
}