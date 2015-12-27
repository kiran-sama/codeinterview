package linkedlist;

/**
 * Created by ksama on 12/27/15.
 */
public class RemoveDuplicates {

  public static void removeDuplicates(Node head){
    Node i = head;
    while(i!=null){
      Node j = i;
      while(j.next!=null){
        if(j.next.value == i.value){
           j.next = j.next.next;
        }else {
          j = j.next;
        }
      }
      i = i.next;
    }

  }

  public static void main(String[] args){
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(12);
    list.add(5);
    list.add(1);
    list.add(1);

    LinkedList.printLinkedList(list.head);
    removeDuplicates(list.head);
    LinkedList.printLinkedList(list.head);
  }
}
