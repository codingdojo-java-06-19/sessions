public class LinkedList<T> {
  public Node<T> head;

  public LinkedList() {
    this.head = null;
  }

  public void add(T value) {
    Node<T> node = new Node<T>(value);
    add(node);
  }

  public void add(Node<T> node) {
    Node<T> currentHead = head;

    node.next = currentHead;
    head = node;
  }

  public void print() {
    System.out.println("Looping to print");

    Node<T> current = head;

    while (current != null) {
      System.out.println("node value is " + current.value);

      current = current.next;
    }
  }
}