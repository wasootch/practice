package org.example.linkedlist;

import org.example.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReverseLinkedListTest {

    private final ReverseLinkedList solution = new ReverseLinkedList();

    private ListNode build(int... vals) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private void assertList(ListNode head, int... expected) {
        for (int val : expected) {
            assertNotNull(head, "List ended too early, expected value: " + val);
            assertEquals(head.val, val);
            head = head.next;
        }
        assertNull(head, "List has extra nodes after expected values");
    }

    @Test
    public void testReverseList_example1() {
        assertList(solution.reverseList(build(1, 2, 3, 4, 5)), 5, 4, 3, 2, 1);
    }

    @Test
    public void testReverseList_example2() {
        assertList(solution.reverseList(build(1, 2)), 2, 1);
    }

    @Test
    public void testReverseList_emptyList() {
        assertNull(solution.reverseList(null));
    }

    @Test
    public void testReverseList_singleNode() {
        assertList(solution.reverseList(build(42)), 42);
    }

    @Test
    public void testReverseList_reverseTwiceIsIdentity() {
        ListNode original = build(1, 2, 3, 4, 5);
        assertList(solution.reverseList(solution.reverseList(original)), 1, 2, 3, 4, 5);
    }

    @Test
    public void testReverseList_negativeValues() {
        assertList(solution.reverseList(build(-5000, -1, 0, 1, 5000)), 5000, 1, 0, -1, -5000);
    }

    @Test
    public void testReverseList_allSameValues() {
        assertList(solution.reverseList(build(7, 7, 7)), 7, 7, 7);
    }

    @Test
    public void testReverseList_tailBecomesHead() {
        ListNode result = solution.reverseList(build(1, 2, 3));
        assertEquals(result.val, 3);
    }

    @Test
    public void testReverseList_headBecomesNullTail() {
        ListNode result = solution.reverseList(build(1, 2, 3));
        while (result.next != null) result = result.next;
        assertEquals(result.val, 1);
        assertNull(result.next);
    }
}
