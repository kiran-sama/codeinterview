package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by ksama on 2/17/2016.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.length() == 0)
            return "";
        LinkedHashMap<Character,Integer> found = new LinkedHashMap<Character, Integer>();
        HashSet<Character> charactersToBeFound = new HashSet<Character>();
        for(char ch:t.toCharArray()){
            charactersToBeFound.add(ch);
        }
        String result = s;
        char[] sa = s.toCharArray();
        for(int i=0;i<sa.length;i++){
            if(charactersToBeFound.contains(sa[i])){
                found.put(sa[i],i);
                if(t.length() == found.size() ){
                    Set<Character> foundChars = found.keySet();
                    char ch = foundChars.iterator().next();
                    int start = found.get(ch);
                    if(i+1-start<result.length()){
                        result = s.substring(start,i+1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(new MinimumWindowSubstring().minWindow("a","a"));
    }
}
