package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ksama on 1/24/16.
 */
public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    HashMap<Integer,ArrayList<String>> twoSumMap = null;
    for(int i=0;i<nums.length-1;i++){
      for(int j=i;j<nums.length;j++){
        ArrayList<String> indices = twoSumMap.get(nums[i]+nums[j]);
        if(indices == null){
          indices = new ArrayList<String>();
          twoSumMap.put(nums[i]+nums[j], indices) ;
        }
        indices.add(i+"_"+j);

      }
    }

    for(int i:twoSumMap.keySet()){

    }

   return null;

  }
}
