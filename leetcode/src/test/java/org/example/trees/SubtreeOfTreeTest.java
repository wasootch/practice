package org.example.trees;

import org.example.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SubtreeOfTreeTest {

    private final SubtreeOfTree solution = new SubtreeOfTree();

    @Test
    public void testIsSubtree_example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        assertTrue(solution.isSubtree(root, subRoot));
    }

    @Test
    public void testIsSubtree_example2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        assertFalse(solution.isSubtree(root, subRoot));
    }

    @Test
    public void testIsSubtree_rootIsOwnSubtree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertTrue(solution.isSubtree(root, root));
    }

    @Test
    public void testIsSubtree_singleNodeMatch() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertTrue(solution.isSubtree(root, new TreeNode(2)));
        assertTrue(solution.isSubtree(root, new TreeNode(3)));
    }

    @Test
    public void testIsSubtree_singleNodeNoMatch() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        assertFalse(solution.isSubtree(root, new TreeNode(99)));
    }

    @Test
    public void testIsSubtree_matchOnRightSide() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeNode subRoot = new TreeNode(3);
        subRoot.left = new TreeNode(4);
        subRoot.right = new TreeNode(5);

        assertTrue(solution.isSubtree(root, subRoot));
    }

    @Test
    public void testIsSubtree_sameValuesDifferentStructure() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        TreeNode subRoot = new TreeNode(2);
        subRoot.right = new TreeNode(3);

        assertFalse(solution.isSubtree(root, subRoot));
    }

    @Test
    public void testIsSubtree_subRootDeeperThanRoot() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        TreeNode subRoot = new TreeNode(1);
        subRoot.left = new TreeNode(2);
        subRoot.right = new TreeNode(3);

        assertFalse(solution.isSubtree(root, subRoot));
    }

    @Test
    public void testIsSubtree_negativeValues() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-10000);
        root.right = new TreeNode(10000);

        assertTrue(solution.isSubtree(root, new TreeNode(-10000)));
        assertFalse(solution.isSubtree(root, new TreeNode(0)));
    }

    @Test
    public void testIsSubtree_duplicateValuesOneMatches() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(4);

        TreeNode subRoot = new TreeNode(4);
        assertTrue(solution.isSubtree(root, subRoot));
    }
}
