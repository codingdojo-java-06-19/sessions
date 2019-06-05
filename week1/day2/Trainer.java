public class Trainer {

  // public void train(Parrot parrot) {
  // parrot.sayHello();
  // }

  // public void train(Human human) {
  // human.sayHello();
  // }

  public void train(SayHello objectThatHasHelloMethod) {
    objectThatHasHelloMethod.sayHello();
  }
}