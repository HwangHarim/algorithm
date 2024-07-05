package algorithmTest.leetCode.tree.maximum_depth_of_binary_tree_104;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.offer(root);
        while(!q.isEmpty()) {
            depth += 1;

            int q_size = q.size();
            for(int i =0; i<q_size;i++){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
        }

        return depth;
    }
}
