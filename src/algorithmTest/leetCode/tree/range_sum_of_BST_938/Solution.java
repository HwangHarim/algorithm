package algorithmTest.leetCode.tree.range_sum_of_BST_938;

import algorithmTest.leetCode.tree.TreeNode;

public class Solution {
    int val =0;
    int low;
    int high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;

        dfs(root);

        return val;
    }

    public void dfs(TreeNode node){
        if(node == null){
            return;
        }

        if(low<=node.val&& node.val<=high){
            val += node.val;
        }

        if(node.left != null){
            dfs(node.left);
        }
        if(node.right != null){
            dfs(node.right);
        }
    }

}