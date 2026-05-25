package org.example.trees;

import org.example.common.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.testng.Assert.*;

public class CodecTest {

    private final SerializeBinaryTree codec = new SerializeBinaryTree();

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private TreeNode buildTree(Integer[] vals) {
        if (vals == null || vals.length == 0 || vals[0] == null) return null;
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < vals.length) {
            TreeNode node = queue.poll();
            if (vals[i] != null) {
                node.left = new TreeNode(vals[i]);
                queue.offer(node.left);
            }
            i++;
            if (i < vals.length && vals[i] != null) {
                node.right = new TreeNode(vals[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    @Test
    public void testCodec_example1() {
        TreeNode root = buildTree(new Integer[]{1, 2, 3, null, null, 4, 5});
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_example2_emptyTree() {
        TreeNode result = codec.deserialize(codec.serialize(null));
        assertNull(result);
    }

    @Test
    public void testCodec_singleNode() {
        TreeNode root = new TreeNode(42);
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_onlyLeftChild() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_onlyRightChild() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_leftSkewedTree() {
        TreeNode root = buildTree(new Integer[]{1, 2, null, 3, null, 4, null});
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_rightSkewedTree() {
        TreeNode root = buildTree(new Integer[]{1, null, 2, null, 3, null, 4});
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_perfectBinaryTree() {
        TreeNode root = buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_negativeValues() {
        TreeNode root = buildTree(new Integer[]{-10, -3, -1, null, null, -5, null});
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_duplicateValues() {
        TreeNode root = buildTree(new Integer[]{5, 5, 5, 5, 5, null, 5});
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_asymmetricTree() {
        TreeNode root = buildTree(new Integer[]{1, 2, 3, 4, null, null, null, 5, null});
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_largeValues() {
        TreeNode root = buildTree(new Integer[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0});
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_zeroRoot() {
        TreeNode root = new TreeNode(0);
        TreeNode result = codec.deserialize(codec.serialize(root));
        assertTrue(isSameTree(root, result));
    }

    @Test
    public void testCodec_serializeTwiceProducesSameTree() {
        TreeNode root = buildTree(new Integer[]{1, 2, 3, null, null, 4, 5});
        String s1 = codec.serialize(root);
        TreeNode t1 = codec.deserialize(s1);
        String s2 = codec.serialize(t1);
        TreeNode t2 = codec.deserialize(s2);
        assertTrue(isSameTree(t1, t2));
    }
}
