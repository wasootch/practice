package org.example.linkedlist;

import org.example.common.ListNode;

import java.util.HashMap;

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
