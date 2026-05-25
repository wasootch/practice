package org.example.linkedlist;

import org.example.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MergeSortedListsTest {

    MergeSortedLists mergeSortedLists = new MergeSortedLists();

    @Test
    public void testMergeKLists_1() {
        ListNode[] lists = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };

        ListNode result = mergeSortedLists.mergeKLists(lists);

        assertEquals(result.val, 1);
        assertEquals(result.next.val, 1);
        assertEquals(result.next.next.val, 2);
        assertEquals(result.next.next.next.val, 3);
        assertEquals(result.next.next.next.next.val, 4);
        assertEquals(result.next.next.next.next.next.val, 4);
        assertEquals(result.next.next.next.next.next.next.val, 5);
        assertEquals(result.next.next.next.next.next.next.next.val, 6);
        assertNull(result.next.next.next.next.next.next.next.next);
    }

    @Test
    public void testMergeKLists_2() {
        ListNode result = mergeSortedLists.mergeKLists(new ListNode[]{});
        assertNull(result);
    }

    @Test
    public void testMergeKLists_3() {
        ListNode result = mergeSortedLists.mergeKLists(new ListNode[]{null});
        assertNull(result);
    }
}
