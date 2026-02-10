package HW2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LomutoPartitionTest {

    @Test
    void testPartitionOnSortedArray() {
        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

        int low = 0;
        int high = arr.length - 1;

        int pivotValue = arr[high]; // pivot is last element
        int p = LomutoQuickSort.partition(arr, low, high);

        // pivot should land somewhere in [low, high]
        assertTrue(p >= low && p <= high);

        // pivot value should be placed exactly at index p
        assertEquals(pivotValue, arr[p]);

        // everything left of p should be <= pivot
        for (int i = low; i < p; i++) {
            assertTrue(arr[i] <= pivotValue, "Left side has something bigger than pivot");
        }

        // everything right of p should be > pivot
        for (int i = p + 1; i <= high; i++) {
            assertTrue(arr[i] > pivotValue, "Right side has something not bigger than pivot");
        }
    }

    @Test
    void testPartitionOnEmptyArray() {
        int[] arr = {};

        // for empty array, we usually call partition(arr, 0, -1).
        int p = LomutoQuickSort.partition(arr, 0, -1);

        // my implementation returns -1 for empty range.
        assertEquals(-1, p);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testPartitionOnGivenUnsortedArray() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};

        int low = 0;
        int high = arr.length - 1;

        int pivotValue = arr[high]; // pivot = 5
        int p = LomutoQuickSort.partition(arr, low, high);

        // basic checks
        assertTrue(p >= low && p <= high);
        assertEquals(pivotValue, arr[p]);

        // partition checks
        for (int i = low; i < p; i++) {
            assertTrue(arr[i] <= pivotValue, "Left side has something bigger than pivot");
        }

        for (int i = p + 1; i <= high; i++) {
            assertTrue(arr[i] > pivotValue, "Right side has something not bigger than pivot");
        }
    }
}