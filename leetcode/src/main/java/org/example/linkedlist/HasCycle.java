package org.example.linkedlist;

import org.example.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    Set<ListNode> set = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        if (set.contains(head)) {
            return true;
        }
        set.add(head);

        return hasCycle(head.next);
    }
}
