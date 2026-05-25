package org.example.graphs;

import org.example.common.Node;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.testng.Assert.*;

public class CloneGraphTest {

    private CloneGraph solution;

    @BeforeMethod
    public void setUp() {
        solution = new CloneGraph();
    }

    // Collects all nodes reachable from a given root via BFS, keyed by val.
    // Assumes vals are unique (which they are in LeetCode's graph).
    private Map<Integer, Node> collectNodes(Node root) {
        Map<Integer, Node> nodes = new HashMap<>();
        if (root == null) return nodes;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        nodes.put(root.val, root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!nodes.containsKey(neighbor.val)) {
                    nodes.put(neighbor.val, neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return nodes;
    }

    @Test
    public void testCloneGraph_null() {
        assertNull(solution.cloneGraph(null));
    }

    @Test
    public void testCloneGraph_singleNode() {
        Node node = new Node(1);
        Node clone = solution.cloneGraph(node);

        assertNotNull(clone);
        assertEquals(clone.val, 1);
        assertTrue(clone.neighbors.isEmpty());
        assertNotSame(clone, node);
    }

    @Test
    public void testCloneGraph_selfLoop() {
        Node node = new Node(1);
        node.neighbors.add(node);

        Node clone = solution.cloneGraph(node);

        assertEquals(clone.val, 1);
        assertEquals(clone.neighbors.size(), 1);
        assertSame(clone.neighbors.get(0), clone);     // clone's neighbor is itself
        assertNotSame(clone.neighbors.get(0), node);   // not the original
    }

    @Test
    public void testCloneGraph_twoNodeEdge() {
        // 1 ↔ 2
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);

        Node clone1 = solution.cloneGraph(n1);
        Node clone2 = clone1.neighbors.get(0);

        assertEquals(clone1.val, 1);
        assertEquals(clone2.val, 2);
        assertEquals(clone2.neighbors.size(), 1);
        assertSame(clone2.neighbors.get(0), clone1);   // back-edge points to clone, not original
        assertNotSame(clone1, n1);
        assertNotSame(clone2, n2);
    }

    @Test
    public void testCloneGraph_fourNodeCycle() {
        // LeetCode example: 1-2-3-4 in a cycle, each node also connects across
        // adjList: [[2,4],[1,3],[2,4],[1,3]]
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2); n1.neighbors.add(n4);
        n2.neighbors.add(n1); n2.neighbors.add(n3);
        n3.neighbors.add(n2); n3.neighbors.add(n4);
        n4.neighbors.add(n1); n4.neighbors.add(n3);

        Node cloneRoot = solution.cloneGraph(n1);

        Map<Integer, Node> clones = collectNodes(cloneRoot);
        assertEquals(clones.size(), 4);

        // Structure matches
        assertEquals(clones.get(1).neighbors.size(), 2);
        assertEquals(clones.get(2).neighbors.size(), 2);
        assertEquals(clones.get(3).neighbors.size(), 2);
        assertEquals(clones.get(4).neighbors.size(), 2);

        // Neighbor values match original
        assertTrue(clones.get(1).neighbors.stream().mapToInt(n -> n.val).anyMatch(v -> v == 2));
        assertTrue(clones.get(1).neighbors.stream().mapToInt(n -> n.val).anyMatch(v -> v == 4));
        assertTrue(clones.get(3).neighbors.stream().mapToInt(n -> n.val).anyMatch(v -> v == 2));
        assertTrue(clones.get(3).neighbors.stream().mapToInt(n -> n.val).anyMatch(v -> v == 4));
    }

    @Test
    public void testCloneGraph_noSharedNodes() {
        // Verify every node in the clone is a distinct object from the original
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.neighbors.add(n2); n1.neighbors.add(n3);
        n2.neighbors.add(n1);
        n3.neighbors.add(n1);

        Node cloneRoot = solution.cloneGraph(n1);

        Map<Integer, Node> originals = collectNodes(n1);
        Map<Integer, Node> clones = collectNodes(cloneRoot);

        for (int val : originals.keySet()) {
            assertNotSame(originals.get(val), clones.get(val),
                    "Node with val=" + val + " is the same object in both graphs");
        }
    }

    @Test
    public void testCloneGraph_mutatingOriginalDoesNotAffectClone() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);

        Node clone1 = solution.cloneGraph(n1);
        int neighborCountBefore = clone1.neighbors.size();

        // Add a new neighbor to the original after cloning
        Node n3 = new Node(3);
        n1.neighbors.add(n3);

        assertEquals(clone1.neighbors.size(), neighborCountBefore);
    }
}
