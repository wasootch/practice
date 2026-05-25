package org.example.design;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LRUCacheTest {

    @Test
    public void testLRUCache_leetcodeExample() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(cache.get(1), 1);
        cache.put(3, 3);
        assertEquals(cache.get(2), -1);
        cache.put(4, 4);
        assertEquals(cache.get(1), -1);
        assertEquals(cache.get(3), 3);
        assertEquals(cache.get(4), 4);
    }

    @Test
    public void testGet_emptyCache_returnsMinusOne() {
        LRUCache cache = new LRUCache(2);
        assertEquals(cache.get(1), -1);
    }

    @Test
    public void testGet_missingKey_returnsMinusOne() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        assertEquals(cache.get(99), -1);
    }

    @Test
    public void testPutAndGet_basic() {
        LRUCache cache = new LRUCache(2);
        cache.put(5, 42);
        assertEquals(cache.get(5), 42);
    }

    @Test
    public void testPut_updateExistingKey_updatesValue() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(1, 99);
        assertEquals(cache.get(1), 99);
    }

    @Test
    public void testPut_updateExistingKey_doesNotEvict() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 100);
        assertEquals(cache.get(2), 2);
        assertEquals(cache.get(1), 100);
    }

    @Test
    public void testCapacityOne_evictsOnSecondPut() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 10);
        cache.put(2, 20);
        assertEquals(cache.get(1), -1);
        assertEquals(cache.get(2), 20);
    }

    @Test
    public void testCapacityOne_updateOnlyKey() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 10);
        cache.put(1, 99);
        assertEquals(cache.get(1), 99);
    }

    @Test
    public void testGet_refreshesRecency() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        assertEquals(cache.get(1), 1);
        assertEquals(cache.get(2), -1);
        assertEquals(cache.get(3), 3);
    }

    @Test
    public void testPut_updateRefreshesRecency() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 100);
        cache.put(3, 3);
        assertEquals(cache.get(1), 100);
        assertEquals(cache.get(2), -1);
        assertEquals(cache.get(3), 3);
    }

    @Test
    public void testEviction_lruOrder() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.get(2);
        cache.put(4, 4);
        assertEquals(cache.get(3), -1);
        assertEquals(cache.get(1), 1);
        assertEquals(cache.get(2), 2);
        assertEquals(cache.get(4), 4);
    }

    @Test
    public void testPut_negativeValue_distinguishedFromNotFound() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, -1);
        assertEquals(cache.get(1), -1);
    }

    @Test
    public void testPut_keyZero() {
        LRUCache cache = new LRUCache(2);
        cache.put(0, 5);
        assertEquals(cache.get(0), 5);
    }

    @Test
    public void testPut_reinsertEvictedKey() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(1, 99);
        assertEquals(cache.get(1), 99);
        assertEquals(cache.get(2), -1);
    }

    @Test
    public void testEviction_sequentialEvictions() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        assertEquals(cache.get(1), -1);
        assertEquals(cache.get(2), -1);
        assertEquals(cache.get(3), 3);
        assertEquals(cache.get(4), 4);
    }
}
