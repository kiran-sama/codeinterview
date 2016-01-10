package linkedlist;

/**
 * Created by ksama on 12/27/15.
 */
public class ReverseLinkedList {

  public static Node reverseLinkedList(Node head){
    Node straight = head;
    Node reverse = null;
    while(straight!=null){
      Node n = straight;
      straight = straight.next;
      n.next = reverse;
      reverse = n;
    }
    return reverse;
  }

  public static void main(String[] args){
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(12);
    list.add(5);
    list.add(1);
    list.add(1);

    LinkedList.printLinkedList(list.head);
    LinkedList.printLinkedList(reverseLinkedList(list.head));
  }
}
