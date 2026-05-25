package org.example.trees;

import org.example.common.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = invertTree(left);
        root.left = invertTree(right);

        return root;
    }
}
