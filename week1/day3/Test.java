public class Test {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList();
    Node<Integer> node = new Node<Integer>(234);

    list.add(node);
    list.add(999);

    list.print();

    LinkedList<String> list2 = new LinkedList();

    list2.add("hello");
    // list2.add(234234);

  }
}