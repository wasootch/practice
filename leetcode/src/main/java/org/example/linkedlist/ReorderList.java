package org.example.linkedlist;

import org.example.common.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;

        while (head != null && head2 != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = head2.next;

            head2.next = head.next;
            head.next = head2;
            head = temp1;
            head2 = temp2;
        }
    }

    ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }
}
