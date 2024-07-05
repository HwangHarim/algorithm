package algorithmTest.leetCode.tree.convert_sorted_array_to_binary_search_tree_108;

import algorithmTest.leetCode.tree.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        return createTree(nums, 0, nums.length-1);
    }

    public TreeNode createTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        TreeNode node = new TreeNode(nums[(start + end)/2]);

        node.left = createTree(nums, start, (start+end)/2 - 1);
        node.right = createTree(nums, (start+end)/2 + 1, end);

        return node;
    }
}
