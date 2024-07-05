package algorithmTest.leetCode.tree.invert_binary_tree_226;

import algorithmTest.leetCode.tree.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        TreeNode newNode = new TreeNode(root.val);

        newNode.left = invertTree(root.right);
        newNode.right = invertTree(root.left);

        return newNode;
    }
}
