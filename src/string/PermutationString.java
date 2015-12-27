package string;

/**
 * Created by ksama on 12/27/15.
 */
public class PermutationString {
  public static boolean isPermutationStrings(String s1, String s2){
    int[] char256 = new int[256];
    for(int i=0;i<s1.length();i++){
      char256[s1.charAt(i)]++;
    }

    for(int i=0;i<s2.length();i++){
      char256[s2.charAt(i)]--;
    }

    for(int i=0;i<char256.length;i++){
      if(char256[i]!=0)
        return false;
    }

    return true;
  }

  public static void main(String args[]){
    System.out.println(isPermutationStrings("sama","masa"));
    System.out.println(isPermutationStrings("sama","MAsa"));
    System.out.println(isPermutationStrings("sama","maasa"));
    System.out.println(isPermutationStrings("samma","massa"));

  }
}
