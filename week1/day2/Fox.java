public class Fox extends Animal {
  public Fox() {
    super("Fox");
  }

  public Fox(int numberOfLegs) {
    super(numberOfLegs, "Fox");
  }

  public void makeSound() {
    System.out.println("Ringdingding");
  }
}