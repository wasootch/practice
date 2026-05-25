package org.example.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    boolean even = true;
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (even) {
            large.add(num);
            small.add(large.poll());
        } else {
            small.add(num);
            large.add(small.poll());
        }

        even = !even;

    }

    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}
