package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        InsertionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {5};
        InsertionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        InsertionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        InsertionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {4, 2, 4, 2, 4};
        InsertionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{2, 2, 4, 4, 4}, arr);
    }

    @Test
    void testNearlySortedArray() {
        int[] arr = {1, 2, 4, 3, 5};
        InsertionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
}
