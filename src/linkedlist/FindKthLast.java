package linkedlist;

/**
 * Created by ksama on 12/27/15.
 */
public class FindKthLast {

  public static int findKthLast(Node node, int k){
    Node lead = node;
    Node follow = node;
    for(int i=0;i<k;i++){
      if(lead.next!=null){
        lead = lead.next;
      }else{
        return -1;
      }
    }
    while(lead.next!=null){
      lead = lead.next;
      follow = follow.next;
    }
    return follow.next.value;
  }

  public static void main(String[] args){
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(12);
    list.add(5);
    list.add(1);
    list.add(1);

    LinkedList.printLinkedList(list.head);
    System.out.print(findKthLast(list.head,3));
  }
}
