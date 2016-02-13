package string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ksama on 2/12/2016.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        HashMap<Character,ArrayList<Integer>> order = new HashMap<Character, ArrayList<Integer>>();
        for(int i=0;i<t.length();i++){
            ArrayList<Integer> nos = order.get(t.charAt(i));
            if(nos == null) {
                nos = new ArrayList<Integer>();
                order.put(t.charAt(i), nos);
            }
            nos.add(i);
        }

        int[] counts = new int[t.length()];
        for(int i=0;i<s.length();i++){
            ArrayList<Integer> nos = order.get(s.charAt(i));
            if(nos!= null){
                for(int index=nos.size()-1;index>=0;index--){
                    if(nos.get(index) == 0){
                        counts[0]++;
                    }else{
                        counts[nos.get(index)] += counts[nos.get(index)-1];
                    }
                }
            }
        }
      return counts[counts.length-1];
    }

    public static void main(String args[]){
        System.out.println(new DistinctSubsequences().numDistinct("abbaababcaaccab","abc"));
    }
}

