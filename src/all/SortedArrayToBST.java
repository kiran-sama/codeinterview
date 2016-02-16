package all;

/**
 * Created by ksama on 2/15/2016.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end){
        if(start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums,start,mid-1);
        root.right = sortedArrayToBSTHelper(nums,mid+1,end);
        return root;
    }


}
