package string;

import java.util.HashMap;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ksama on 2/17/2016.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p){

      return isMatch2(s, p);
    }
    private boolean isMatchHelper(String s, String p,int s1,int p1,int[][] cache) {
        if(cache[s1][p1] != 0){
            return cache[s1][p1]==1;
        }
        int matchedIndexSoFar = s1-1;
        char[] pa = p.toCharArray();
        boolean wildCardFound = false;
        for(int i=p1;i<pa.length;i++){
           char ch = pa[i];
           if(ch == '?'){
             if(matchedIndexSoFar>=s.length()-1) {
                 cache[s1][p1]=-1;
                 return false;
             }
             else
                 matchedIndexSoFar++;
           }else if(ch == '*'){
             wildCardFound = true;
           }else{
               if(wildCardFound){
                   int index = s.indexOf(ch,matchedIndexSoFar);
                   while(index!=-1 && !isMatchHelper(s,p,index+1,i+1,cache)){
                       index = s.indexOf(ch,index+1);
                   }
                   if(index == -1) {
                       cache[s1][p1] =-1;
                       return false;
                   }
                   else {
                       cache[s1][p1] =1;
                       return true;
                   }

               } else{
                   if(matchedIndexSoFar>=s.length()-1) {
                       cache[s1][p1] = -1;
                       return false;
                   }
                   if(ch == s.charAt(++matchedIndexSoFar))
                       continue;
                   else {
                       cache[s1][p1] = -1;
                       return false;
                   }
               }
           }
        }
        cache[s1][p1] = (wildCardFound||matchedIndexSoFar == s.length()-1)==true?1:-1 ;
        return wildCardFound||matchedIndexSoFar == s.length()-1;
    }
    public boolean isMatch2(String s, String p) {
        int saved_p=-1, saved_s=-1;
        int indexP=0;
        for(int indexS=0; indexS<s.length();){

            if(indexP<p.length() && (s.charAt(indexS)==p.charAt(indexP)||p.charAt(indexP)=='?')){
                //match to a single character
                indexP++;
                indexS++;
            }
            else if(indexP<p.length() && p.charAt(indexP)=='*'){
                // go into the * state, we need to save the P next position and save S next position
                // when any mismatch happen, we can revert the search to it previous state '*'
                saved_p=indexP;
                //move the saved_s, next time it should skip current one
                saved_s=indexS+1;
                indexP++;
            }
            else if(saved_p!=-1){
                //means not match, we need to revert
                indexP=saved_p;
                indexS=saved_s;
            }
            else{
                //means not match, but not wildcard
                return false;
            }
        }
        //examine the left char in the pattern
        //they should all be '*' if any char left
        for(int index=indexP; index<p.length();index++){
            if(p.charAt(index)!='*'){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){

        System.out.println(new WildcardMatching().isMatch("abcdef","a*f"));
    }
    //"aabbbabaaaaaabbabbaabbabbbabaabaaabbbabbabbbbababbabaaaaaabaabaabbbababaaabbaabaaabaabaabaaabaaababbaabababbabbababbbbabbababbbababaaaabaabbbabababaabbbaaababbbbbbbbabaaabbaabbbaababaaaababababbabbbbbb"
    //"a*bab***b**abbabaa**a*a**b****b*b*****b*bb***a**a**a***baba*abbbaa***bb**bbabb*b*b*bab*a****a*bb*a**b"
}
