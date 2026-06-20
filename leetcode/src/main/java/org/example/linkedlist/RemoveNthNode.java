package org.example.linkedlist;

import org.example.common.ListNode;

import java.util.HashMap;

///
/// 19. Remove Nth Node From End of List
/// Medium
///
/// Given the head of a linked list, remove the nth node from the end of the list and return its head.
///
/// Example 1:
/// Input: head = [1,2,3,4,5], n = 2
/// Output: [1,2,3,5]
///
/// Example 2:
/// Input: head = [1], n = 1
/// Output: []
///
/// Example 3:
/// Input: head = [1,2], n = 1
/// Output: [1]
///
/// Constraints:
/// The number of nodes in the list is sz.
/// 1 <= sz <= 30
/// 0 <= Node.val <= 100
/// 1 <= n <= sz
///
/// Follow up: Could you do this in one pass?
///
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode slow = head;
        int j = 1;
        while (slow != null) {
            map.put(j++, slow);
            slow = slow.next;
        }

        if (n < map.size()) {
            int i = map.size() - n + 1;
            map.get(i - 1).next = (n == 1) ? null : map.get(i + 1);
        } else if (n == map.size()) {
            head = head.next;
        }

        return head;
    }
}
