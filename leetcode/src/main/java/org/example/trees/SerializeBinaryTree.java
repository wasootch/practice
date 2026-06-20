package org.example.trees;

import org.example.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

///
/// 297. Serialize and Deserialize Binary Tree
/// Hard
///
/// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
/// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
/// Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
///
/// Example 1:
/// Input: root = [1,2,3,null,null,4,5]
/// Output: [1,2,3,null,null,4,5]
///
/// Example 2:
/// Input: root = []
/// Output: []
///
/// Constraints:
/// The number of nodes in the tree is in the range [0,104].
/// -1000 <= Node.val <= 1000
///
public class SerializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");
            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            String val = values[i];
            if (!val.equals("null")) {
                TreeNode child = new TreeNode(Integer.parseInt(val));
                parent.left = child;
                queue.add(child);
            }

            val = values[++i];
            if (!val.equals("null")) {
                TreeNode child = new TreeNode(Integer.parseInt(val));
                parent.right = child;
                queue.add(child);
            }
        }

        return root;
    }
}
