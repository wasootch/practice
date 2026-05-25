package org.example.trees;

import org.example.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SameTreeTest {

    private final SameTree solution = new SameTree();

    @Test
    public void testIsSameTree_example1() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        assertTrue(solution.isSameTree(p, q));
    }

    @Test
    public void testIsSameTree_example2() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        assertFalse(solution.isSameTree(p, q));
    }

    @Test
    public void testIsSameTree_example3() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        assertFalse(solution.isSameTree(p, q));
    }

    @Test
    public void testIsSameTree_bothNull() {
        assertTrue(solution.isSameTree(null, null));
    }

    @Test
    public void testIsSameTree_oneNull() {
        assertFalse(solution.isSameTree(new TreeNode(1), null));
        assertFalse(solution.isSameTree(null, new TreeNode(1)));
    }

    @Test
    public void testIsSameTree_singleNodeMatch() {
        assertTrue(solution.isSameTree(new TreeNode(7), new TreeNode(7)));
    }

    @Test
    public void testIsSameTree_singleNodeMismatch() {
        assertFalse(solution.isSameTree(new TreeNode(1), new TreeNode(2)));
    }

    @Test
    public void testIsSameTree_sameReference() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        assertTrue(solution.isSameTree(root, root));
    }

    @Test
    public void testIsSameTree_extraSubtreeOnLeft() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.left.left = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);

        assertFalse(solution.isSameTree(p, q));
    }

    @Test
    public void testIsSameTree_negativeValues() {
        TreeNode p = new TreeNode(-10000);
        p.left = new TreeNode(-1);
        p.right = new TreeNode(10000);

        TreeNode q = new TreeNode(-10000);
        q.left = new TreeNode(-1);
        q.right = new TreeNode(10000);

        assertTrue(solution.isSameTree(p, q));
    }

    @Test
    public void testIsSameTree_rootValueDiffers() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(99);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        assertFalse(solution.isSameTree(p, q));
    }
}
