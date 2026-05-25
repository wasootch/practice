package org.example.trees;

import org.example.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
