package org.example.linkedlist;

import org.example.common.ListNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReorderListTest {

    ReorderList reorderList = new ReorderList();

    @Test
    public void testReorderList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reorderList.reorderList(node1);

        Assert.assertEquals(node1.next, node4, "actual: " + node1.next.val + " expected: " + node4.val);
        assertFalse(hasCycle(node1), "list has a cycle");
    }

    @Test
    public void testReorderList2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reorderList.reorderList(node1);

        Assert.assertEquals(node1.next, node5, "actual: " + node1.next.val + " expected: " + node5.val);
        assertFalse(hasCycle(node1), "list has a cycle");
    }

    private boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
