package string;

/**
 * Created by ksama on 12/27/15.
 */
public class StringUniqueCharacters {

  public static boolean isUniqueCharString(String input){
    int[] char256 = new int[256];
    for(int i=0;i<input.length();i++){
      int val = input.charAt(i);
      if(char256[val]==1)
        return false;
      else
        char256[val]=1;
    }
    return true;
  }

  public static void main(String args[]){
    System.out.println(isUniqueCharString("daghjkdgsajhk"));
    System.out.println(isUniqueCharString("ABCFERT"));
    System.out.println(isUniqueCharString("ABCabc"));
    System.out.println(isUniqueCharString("GJHDKGHJAS"));

  }
}
