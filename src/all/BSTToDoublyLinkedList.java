package all;

import java.util.Stack;

/**
 * Created by ksama on 2/17/2016.
 */
public class BSTToDoublyLinkedList {
    public BiNode convertBSTToDLL(BiNode root){
        BiNode head = null;
        BiNode tail = null;
        Stack<BiNode> depth = new Stack<BiNode>();
        preProcess(depth, root);
        while(!depth.isEmpty()){
            BiNode temp = depth.pop();
            preProcess(depth,temp.rightOrNext);
            if(tail == null){
                head = tail = temp;
                tail.leftOrPrev = null;
            }else{
                tail.rightOrNext = temp;
                temp.leftOrPrev = tail;
                tail = temp;
            }
            tail.rightOrNext = null;
        }
        return head;
    }

    private void preProcess(Stack<BiNode> depth,BiNode node){
        while(node!= null){
            depth.add(node);
            node = node.leftOrPrev;
        }
    }
}
