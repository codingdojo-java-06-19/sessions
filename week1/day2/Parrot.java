public class Parrot extends Animal implements SayHello {
  public void sayHello() {
    System.out.println("bawk hello baawk");
  }

  public void makeSound() {
    sayHello();
  }
}