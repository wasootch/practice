package org.example.linkedlist;

import org.example.common.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode node = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = node;
            node = head;
            if (tmp != null) {
                head = tmp;
            } else break;
        }

        return head;
    }
}
