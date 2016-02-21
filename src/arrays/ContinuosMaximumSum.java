package arrays;

/**
 * Created by ksama on 2/16/2016.
 */
public class ContinuosMaximumSum {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<nums.length;i++){
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            currentSum = Math.max(0,currentSum);
        }
        return maxSum;
    }

}
