package org.example.linkedlist;

import org.example.common.ListNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HasCycleTest {

    private HasCycle hasCycle;

    @BeforeMethod
    public void beforeMethod() {
        hasCycle = new HasCycle();
    }

    @Test
    public void testHasCycle() {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeNeg4 = new ListNode(-4);

        node3.next = node2;
        node2.next = node0;
        node0.next = nodeNeg4;
        nodeNeg4.next = node2;

        assertTrue(hasCycle.hasCycle(node3));
    }

    @Test
    public void testHasCycle_2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;
        node2.next = node1;

        assertTrue(hasCycle.hasCycle(node1));
    }

    @Test
    public void testHasCycle_3() {
        ListNode node1 = new ListNode(1);
        assertFalse(hasCycle.hasCycle(node1));
    }

    @Test
    public void testHasCycle_1_2() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        assertFalse(hasCycle.hasCycle(node1));
    }

    @Test
    public void testHasCycle_Long() {
        ListNode node0 = new ListNode(-21);
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(17);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(26);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(35);
        ListNode node8 = new ListNode(33);
        ListNode node9 = new ListNode(-7);
        ListNode node10 = new ListNode(-16);
        ListNode node11 = new ListNode(27);
        ListNode node12 = new ListNode(-12);
        ListNode node13 = new ListNode(6);
        ListNode node14 = new ListNode(29);
        ListNode node15 = new ListNode(-12);
        ListNode node16 = new ListNode(5);
        ListNode node17 = new ListNode(9);
        ListNode node18 = new ListNode(20);
        ListNode node19 = new ListNode(14);
        ListNode node20 = new ListNode(14);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(13);
        ListNode node23 = new ListNode(-24);
        ListNode node24 = new ListNode(21);
        ListNode node25 = new ListNode(23);
        ListNode node26 = new ListNode(-21);
        ListNode node27 = new ListNode(5);

        node0.next = node1; node1.next = node2; node2.next = node3; node3.next = node4;
        node4.next = node5; node5.next = node6; node6.next = node7; node7.next = node8;
        node8.next = node9; node9.next = node10; node10.next = node11; node11.next = node12;
        node12.next = node13; node13.next = node14; node14.next = node15; node15.next = node16;
        node16.next = node17; node17.next = node18; node18.next = node19; node19.next = node20;
        node20.next = node21; node21.next = node22; node22.next = node23; node23.next = node24;
        node24.next = node25; node25.next = node26; node26.next = node27;

        assertFalse(hasCycle.hasCycle(node0));
    }
}
