package string;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by ksama on 1/18/16.
 */
public class ScrambleString {
  public boolean isScramble(String s1, String s2) {
    return isScrambleHelper(s1,0,s1.length()-1,s2,0,s2.length()-1,createMemo(s1));

  }

  private boolean isScrambleHelper(String s1,int start1,int end1,String s2,int start2,int end2,Hashtable<Character,ArrayList<Integer>> memo){

    if(start1 == end1){
      return s1.charAt(start1) == s2.charAt(start2);
    }

    if(start1>end1)
      return true;

    ArrayList<Integer> indices = memo.get(s2.charAt(start2));
    if(indices == null)
      return false;
    for(Integer i:indices){
        if(i>=start1 && i<=end1){
           int j=i;
          int k = start2;
          while(j<=end1&&start2<=end2&&s1.charAt(j)==s2.charAt(k)){
            j++;
            k++;
          }
          k--;
          if(isScrambleHelper(s1,start1,i-1,s2,k+1,k+1+i-1-start1,memo)&&isScrambleHelper(s1,j,end1,s2,end2-end1+j,end2,memo)){
            return true;
          }
          if(isScrambleHelper(s1,start1,i-1,s2,end2+start1-i+1,end2,memo)&&isScrambleHelper(s1,j,end1,s2,k+1,k+1+end1-j,memo)){
            return true;
          }

        }
    }
    return false;

  }

  private Hashtable<Character,ArrayList<Integer>> createMemo(String s1){
    Hashtable<Character,ArrayList<Integer>> memo = new Hashtable<Character, ArrayList<Integer>>();
    for(int i=0;i<s1.length();i++){
      if(memo.get(s1.charAt(i))!= null){
         memo.get(s1.charAt(i)).add(i);
      }else{
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        indexes.add(i);
        memo.put(s1.charAt(i),indexes);
      }
    }
    return memo;
  }

  public static void main(String args[]){
   // System.out.println(new ScrambleString().isScramble("cab","cba"));
    System.out.println(new ScrambleString().isScramble("ccabcbabcbabbbbcbb","bbbbabccccbbbabcba"));
  }
}
