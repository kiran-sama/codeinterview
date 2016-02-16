package all;

/**
 * Created by ksama on 2/15/2016.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)==-1?false:true;
    }

    private int getHeight(TreeNode node){
        if(node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if(left==-1 || right == -1 || Math.abs(left-right)>1) {
            return -1;
        }else{
            return 1+Math.max(left,right);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode child = new TreeNode(2);
        child.right = new TreeNode(3);
        root.right = child;
        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }
}
