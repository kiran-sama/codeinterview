package string;

/**
 * Created by ksama on 1/6/16.
 */
public class ShortestPalindrome {

  public String shortestPalindrome(String input){
    StringBuffer prefixBuffer = new StringBuffer();
    int i =0;
    int j = input.length()-1;
    boolean partialMatch = false;
    while(i<=j){
      if(input.charAt(i)==input.charAt(j)){
        i++;
        j--;
        partialMatch = true;
      } else{
        if(partialMatch){
          for(int k = input.length()-1-prefixBuffer.length();k>=j;k--){
            prefixBuffer.append(input.charAt(k));
          }
          i =0;
          j--;
          partialMatch = false;
        }else {
          prefixBuffer.append(input.charAt(j));
          j--;
        }
      }
    }
    return prefixBuffer.toString()+input;
  }

  public String shortestPalindrome2(String s){
    int j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == s.charAt(j)) { j += 1; }
    }
    if (j == s.length()) { return s; }
    String suffix = s.substring(j);
    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome2(s.substring(0, j)) + suffix;
  }

  public static void main(String[] args){
    System.out.println(new ShortestPalindrome().shortestPalindrome ("caaaceaa"));
    System.out.println(new ShortestPalindrome().shortestPalindrome2("aacdedcdaa"));
  }
}
