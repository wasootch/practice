package org.example.trees;

import org.example.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaximumDepthBinaryTreeTest {

    private final MaximumDepthBinaryTree solution = new MaximumDepthBinaryTree();

    @Test
    public void testMaxDepth_example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        assertEquals(solution.maxDepth(root), 3);
    }

    @Test
    public void testMaxDepth_example2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        assertEquals(solution.maxDepth(root), 2);
    }

    @Test
    public void testMaxDepth_nullRoot() {
        assertEquals(solution.maxDepth(null), 0);
    }

    @Test
    public void testMaxDepth_singleNode() {
        assertEquals(solution.maxDepth(new TreeNode(42)), 1);
    }

    @Test
    public void testMaxDepth_balancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        assertEquals(solution.maxDepth(root), 3);
    }

    @Test
    public void testMaxDepth_leftSkewed() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        assertEquals(solution.maxDepth(root), 4);
    }

    @Test
    public void testMaxDepth_rightSkewed() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        assertEquals(solution.maxDepth(root), 4);
    }

    @Test
    public void testMaxDepth_deeperOnRight() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        assertEquals(solution.maxDepth(root), 4);
    }

    @Test
    public void testMaxDepth_deeperOnLeft() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right = new TreeNode(5);

        assertEquals(solution.maxDepth(root), 4);
    }
}
