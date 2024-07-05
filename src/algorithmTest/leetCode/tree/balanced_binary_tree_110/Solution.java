package algorithmTest.leetCode.tree.balanced_binary_tree_110;

import algorithmTest.leetCode.tree.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if(left == -1 || right == -1 || Math.abs(left-right) > 1){
            return -1;
        }

        return Math.max(left, right)+1;
    }
}
