package org.example.linkedlist;

import org.example.common.ListNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MergeTwoSortedListsTest {

    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @Test
    public void testMergeTwoLists_1() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = mergeTwoSortedLists.mergeTwoLists(list1, list2);

        assertEquals(result.val, 1);
        assertEquals(result.next.val, 1);
        assertEquals(result.next.next.val, 2);
        assertEquals(result.next.next.next.val, 3);
        assertEquals(result.next.next.next.next.val, 4);
        assertEquals(result.next.next.next.next.next.val, 4);
        assertNull(result.next.next.next.next.next.next);
    }

    @Test
    public void testMergeTwoLists_2() {
        ListNode result = mergeTwoSortedLists.mergeTwoLists(null, null);
        assertNull(result);
    }

    @Test
    public void testMergeTwoLists_3() {
        ListNode list2 = new ListNode(0);
        ListNode result = mergeTwoSortedLists.mergeTwoLists(null, list2);
        assertEquals(result.val, 0);
        assertNull(result.next);
    }
}
