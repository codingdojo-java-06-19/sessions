public abstract class Animal implements IAnimal {
  // primative values caannot be null
  protected int numberOfLegs;
  protected String type;
  protected String name;

  public Animal(int numberOfLegs, String type) {
    this.numberOfLegs = numberOfLegs;
    this.type = type;
  }

  public Animal(String type) {
    this.type = type;
    this.numberOfLegs = 8;
  }

  public Animal() {
    this.numberOfLegs = 8;
    this.type = "Cat";
  }
  // public Animal(String name) {
  // this.name = name;
  // }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNumberOfLegs(int legs) {
    this.numberOfLegs = legs;
  }

  public int getNumberOfLegs() {
    return this.numberOfLegs;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}