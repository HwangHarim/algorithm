package algorithmTest.leetCode.tree.binary_search_tree_to_greater_sum_tree_1038;

import algorithmTest.leetCode.tree.TreeNode;

public class Solution {
    int val = 0;

    public TreeNode bstToGst(TreeNode root) {

        if (root != null) {
            bstToGst(root.right);
            val += root.val;
            root.val = val;
            bstToGst(root.left);
        }

        return root;
    }
}
