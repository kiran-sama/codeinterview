package stack;

import java.util.Stack;

/**
 * Created by ksama on 2/2/16.
 */
public class BinaryTreeSerialization {

  public boolean isValidSerialization(String preorder) {
    Stack<Integer> stack = new Stack<Integer>();
    String[] ints = preorder.split(",");
    for(int i=0;i<ints.length;i++){
      Integer temp =  null;
      try {
        temp = Integer.parseInt(ints[i]);
      }catch (Exception e){}
      if(temp!=null) {
        stack.push(temp);
      }else{
        while(stack.size()>1 && stack.peek() == null){
          stack.pop();
          if(stack.peek()!=null) {
            stack.pop();
          }
        }
        stack.push(null);
      }
    }
    if(stack.size()==1 && stack.peek()==null){
      return true;
    }  else{
      return false;
    }
  }

  public static void main(String args[]){
    System.out.println(new BinaryTreeSerialization().isValidSerialization("9,3,4,1,2,6,#,#,#,#,#,#,#"));
  }

}
