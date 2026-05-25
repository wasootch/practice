package org.example.linkedlist;

import org.example.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RemoveNthNodeTest {

    RemoveNthNode removeNthNode = new RemoveNthNode();

    @Test
    public void testRemoveNthFromEnd() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = removeNthNode.removeNthFromEnd(node1, 2);

        assertEquals(result.val, 1);
        assertEquals(result.next.val, 2);
        assertEquals(result.next.next.val, 3);
        assertEquals(result.next.next.next.val, 5);
        assertNull(result.next.next.next.next);
    }

    @Test
    public void testRemoveNthFromEnd_2() {
        ListNode node1 = new ListNode(1);
        ListNode result = removeNthNode.removeNthFromEnd(node1, 1);
        assertNull(result);
    }

    @Test
    public void testRemoveNthFromEnd_3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode result = removeNthNode.removeNthFromEnd(node1, 1);
        assertEquals(result.val, 1);
        assertNull(result.next);
    }

    @Test
    public void testRemoveNthFromEnd_4() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode result = removeNthNode.removeNthFromEnd(node1, 2);
        assertEquals(result.val, 2);
        assertNull(result.next);
    }

    @Test
    public void testRemoveNthFromEnd_5() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode result = removeNthNode.removeNthFromEnd(node1, 1);

        assertEquals(result.val, 3);
        assertEquals(result.next.val, 7);
        assertEquals(result.next.next.val, 9);
        assertEquals(result.next.next.next.val, 3);
        assertEquals(result.next.next.next.next.val, 5);
        assertEquals(result.next.next.next.next.next.val, 8);
        assertNull(result.next.next.next.next.next.next);
    }
}
