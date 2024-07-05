package algorithmTest.leetCode.tree.display_of_binary_tree_543;

import algorithmTest.leetCode.tree.TreeNode;

public class Solution {
    int longest = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return this.longest;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        this.longest = Math.max(this.longest, left + right + 2);
        return Math.max(left, right) + 1;
    }
}