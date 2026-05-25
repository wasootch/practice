package org.example.trees;

import org.example.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InvertBinaryTreeTest {

    private final InvertBinaryTree solution = new InvertBinaryTree();

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    @Test
    public void testInvertTree_example1() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode expected = new TreeNode(4);
        expected.left = new TreeNode(7);
        expected.right = new TreeNode(2);
        expected.left.left = new TreeNode(9);
        expected.left.right = new TreeNode(6);
        expected.right.left = new TreeNode(3);
        expected.right.right = new TreeNode(1);

        assertTrue(isSameTree(solution.invertTree(root), expected));
    }

    @Test
    public void testInvertTree_example2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode expected = new TreeNode(2);
        expected.left = new TreeNode(3);
        expected.right = new TreeNode(1);

        assertTrue(isSameTree(solution.invertTree(root), expected));
    }

    @Test
    public void testInvertTree_emptyTree() {
        assertNull(solution.invertTree(null));
    }

    @Test
    public void testInvertTree_singleNode() {
        TreeNode root = new TreeNode(42);
        TreeNode result = solution.invertTree(root);
        assertNotNull(result);
        assertEquals(result.val, 42);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    public void testInvertTree_invertTwiceIsIdentity() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode original = new TreeNode(4);
        original.left = new TreeNode(2);
        original.right = new TreeNode(7);
        original.left.left = new TreeNode(1);
        original.left.right = new TreeNode(3);

        assertTrue(isSameTree(solution.invertTree(solution.invertTree(root)), original));
    }

    @Test
    public void testInvertTree_onlyLeftChild() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        TreeNode result = solution.invertTree(root);
        assertNull(result.left);
        assertNotNull(result.right);
        assertEquals(result.right.val, 2);
    }

    @Test
    public void testInvertTree_onlyRightChild() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        TreeNode result = solution.invertTree(root);
        assertNotNull(result.left);
        assertNull(result.right);
        assertEquals(result.left.val, 2);
    }

    @Test
    public void testInvertTree_rootValueUnchanged() {
        TreeNode root = new TreeNode(99);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        assertEquals(solution.invertTree(root).val, 99);
    }

    @Test
    public void testInvertTree_negativeValues() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(-100);
        root.right = new TreeNode(100);

        TreeNode result = solution.invertTree(root);
        assertEquals(result.val, -10);
        assertEquals(result.left.val, 100);
        assertEquals(result.right.val, -100);
    }
}
