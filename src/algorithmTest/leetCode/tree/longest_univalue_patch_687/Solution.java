package algorithmTest.leetCode.tree.longest_univalue_patch_687;

import algorithmTest.leetCode.tree.TreeNode;

public class Solution {
    int answer = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return answer;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (node.left != null && node.left.val == node.val) {
            left += 1;
        } else {
            left = 0;
        }
        if (node.right != null && node.right.val == node.val) {
            right += 1;
        } else {
            right = 0;
        }
        answer = Math.max(answer, right + left);
        return Math.max(left, right);
    }
}