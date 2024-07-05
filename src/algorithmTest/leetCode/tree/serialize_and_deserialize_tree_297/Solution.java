package algorithmTest.leetCode.tree.serialize_and_deserialize_tree_297;

import algorithmTest.leetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q =new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();

        sb.append(String.valueOf("#," + root.val));

        while(!q.isEmpty()){
            TreeNode now = q.poll();

            if(now.left != null){
                q.add(now.left);
                sb.append(String.valueOf(","+now.left.val));
            } else{
                sb.append(",#");
            }
            if(now.right != null){
                q.add(now.right);
                sb.append(String.valueOf(","+now.right.val));
            } else{
                sb.append(",#");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }

        String[] nodes = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
        Queue<TreeNode> q = new LinkedList<>();

        int index =2;
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode  now = q.poll();

            if(!nodes[index].equals("#")){
                now.left = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(now.left);
            }

            index += 1;
            if(!nodes[index].equals("#")){
                now.right = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(now.right);
            }
            index += 1;
        }
        return root;
    }
}
