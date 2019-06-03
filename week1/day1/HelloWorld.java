import java.util.ArrayList;

public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello Worlds");
    int integer = 10;
    Integer int2 = 10;
    double pi = 3.14;
    boolean bool = true;
    char myChar = 'a';
    String myStr = "this is a string";

    ArrayList<Integer> array = new ArrayList<Integer>();

    array.add(234);
    array.add(integer);

    // if (true == true ) {
    // } else if (false == false) {

    // }

    for (int index = 0; index < array.size(); index++) {
      int current = array.get(index);

      System.out.println(current);
    }

    for (int value : array) {
      System.out.println(value);
    }

    System.out.println(array);

  }
}
