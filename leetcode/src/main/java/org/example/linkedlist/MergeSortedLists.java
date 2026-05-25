package org.example.linkedlist;

import org.example.common.ListNode;

import java.util.PriorityQueue;

public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode head = new ListNode(0);
        ListNode node = head;

        while (queue.isEmpty() == false) {
            ListNode current = queue.poll();
            node.next = current;
            node = node.next;

            if (current.next != null) {
                queue.offer(current.next);
            }
        }

        return head.next;
    }
}
