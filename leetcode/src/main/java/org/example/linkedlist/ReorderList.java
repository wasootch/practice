package org.example.linkedlist;

import org.example.common.ListNode;

///
/// 143. Reorder List
/// Medium
///
/// You are given the head of a singly linked-list. The list can be represented as:
/// L0 → L1 → … → Ln - 1 → Ln
/// Reorder the list to be on the following form:
/// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
/// You may not modify the values in the list's nodes. Only nodes themselves may be changed.
///
/// Example 1:
/// Input: head = [1,2,3,4]
/// Output: [1,4,2,3]
///
/// Example 2:
/// Input: head = [1,2,3,4,5]
/// Output: [1,5,2,4,3]
///
/// Constraints:
/// The number of nodes in the list is in the range [1,5*104].
/// 1 <= Node.val <= 1000
///
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
