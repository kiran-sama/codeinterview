package linkedlist;

/**
 * Created by ksama on 12/27/15.
 */
public class AddLinkedListRepresentedNumbers {

  public static Node addReversedNumbers(Node num1,Node num2){
    return  addReversedNumbersHelper(num1, num2, 0);
  }

  public static Node addStraightNumbers(Node num1,Node num2){
     int length1 = LinkedList.getLinkedListLength(num1);
     int length2 = LinkedList.getLinkedListLength(num2);
     if(length1<length2){
         num1 = padLinkedListforAdd(num1,length2-length1);
     }else if(length1>length2){
       num2 = padLinkedListforAdd(num2,length1-length2);
     }
    Node additionResult = addStraightNumbersHelper(num1, num2);
    if(additionResult.value>10){
      int carry = additionResult.value/10;
      additionResult.value=additionResult.value%10;
      Node newHead = new Node(carry);
      newHead.next = additionResult;
      additionResult = newHead;
    }
    return additionResult;
  }

  /*
   * Both LinkedLists are of same size as they have been balance already
   */
  public static Node addStraightNumbersHelper(Node num1,Node num2){
      if(num1 == null){
        return null;
      }
      int carry  = 0;
      Node result = addStraightNumbersHelper(num1.next,num2.next);
      if(result!=null) {
        carry = result.value / 10;
        result.value = result.value % 10;
      }
      Node superResult = new Node(num1.value+num2.value+carry);
      superResult.next=result;
    return superResult;

  }

  public static Node padLinkedListforAdd(Node node,int padSize){
     Node head = new Node(0);
     Node tail = head;
    for(int i=1;i<padSize;i++){
       Node n = new Node(0);
      tail.next = n;
      tail = n;
    }
    tail.next = node;
    return head;
  }



  private static Node addReversedNumbersHelper(Node num1,Node num2,int carry){
    if(num1 == null && num2 == null && carry ==0){
      return null;
    }
    Node result = new Node(carry);
    int value = carry;
    if(num1 != null){
      value += num1.value;
    }

    if(num2 != null){
      value += num2.value;
    }

    result.value = value%10;
    if(num1!=null || num2!=null){
         Node next = addReversedNumbersHelper(num1!=null?num1.next:null,num2!=null?num2.next:null,value/10);
         result.next = next;
    }
    return result;
  }


  public static void main(String args[]){
    LinkedList num1 = new LinkedList();
    num1.add(5);
    num1.add(8);
    num1.add(1);

    LinkedList num2 = new LinkedList();
    num2.add(1);
    num2.add(9);
    num2.add(5);

    LinkedList.printLinkedList(addReversedNumbers(num1.head, num2.head));
    LinkedList.printLinkedList(addStraightNumbersHelper(num1.head, num2.head));
  }
}
