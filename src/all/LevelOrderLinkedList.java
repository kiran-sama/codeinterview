package all;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksama on 2/15/2016.
 */
public class LevelOrderLinkedList {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        levelOrderHelper(root,0,levelOrderList);
        return levelOrderList;
    }

    private void levelOrderHelper(TreeNode root,int level,List<List<Integer>> levelOrderList){
       if(root!=null){
           List<Integer> levelList = null;
           if(level>levelOrderList.size()-1){
               levelList = new ArrayList<Integer>();
               levelOrderList.add(levelList);
           }else{
               levelList = levelOrderList.get(level);
           }
           levelList.add(root.val);
           levelOrderHelper(root.left,level+1,levelOrderList);
           levelOrderHelper(root.right,level+1,levelOrderList);
       }
    }
}
