package all;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ksama on 2/15/2016.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isChildAndParent(p,q)){
            return p;
        }
        if(isChildAndParent(q,p)){
            return q;
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
       postOrderSearch(root, p, q,result);
        if(result.size() ==0)
            return null;
        else
            return result.get(0);
    }

    private int postOrderSearch(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> result){
        if(root != null && result.size()==0){
            int left = postOrderSearch(root.left,p,q,result);
            int right = postOrderSearch(root.right,p,q,result);
            if(left == 1 && right ==1){
                result.add(root);
            }
            int c =0;
            if(root == p || root == q){
             c++;
            }

            return left+right+c;
        }
        return 0;
    }

    private boolean isChildAndParent(TreeNode parent,TreeNode child){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(parent);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == child)
                return true;
            if(node != null){
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return false;
    }
}
