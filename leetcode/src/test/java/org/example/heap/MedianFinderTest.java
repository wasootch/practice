package org.example.heap;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MedianFinderTest {

    @Test
    public void testMedianFinder_example1() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        assertEquals(mf.findMedian(), 1.5);
        mf.addNum(3);
        assertEquals(mf.findMedian(), 2.0);
    }

    @Test
    public void testMedianFinder_singleElement() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(5);
        assertEquals(mf.findMedian(), 5.0);
    }

    @Test
    public void testMedianFinder_evenCount() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(3);
        mf.addNum(5);
        mf.addNum(7);
        assertEquals(mf.findMedian(), 4.0);
    }

    @Test
    public void testMedianFinder_outOfOrderInserts() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        mf.addNum(1);
        mf.addNum(4);
        assertEquals(mf.findMedian(), 4.0);
        mf.addNum(2);
        assertEquals(mf.findMedian(), 3.0);
    }

    @Test
    public void testMedianFinder_negativeNumbers() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-3);
        mf.addNum(-1);
        mf.addNum(-2);
        assertEquals(mf.findMedian(), -2.0);
    }

    @Test
    public void testMedianFinder_duplicates() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(2);
        mf.addNum(2);
        mf.addNum(2);
        assertEquals(mf.findMedian(), 2.0);
    }
}
