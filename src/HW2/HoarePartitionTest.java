package HW2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HoarePartitionTest {

    @Test
    void testPartitionOnSortedArray() {
        int[] arr = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

        int low = 0;
        int high = arr.length - 1;

        // Hoare pivot is the first element
        int pivotValue = arr[low];

        int p = HoareQuickSort.partition(arr, low, high);

        // p should be inside the range
        assertTrue(p >= low && p <= high);

        // left side should be <= pivot
        for (int i = low; i <= p; i++) {
            assertTrue(arr[i] <= pivotValue, "Left side has something bigger than pivot");
        }

        // right side should be >= pivot
        for (int i = p + 1; i <= high; i++) {
            assertTrue(arr[i] >= pivotValue, "Right side has something smaller than pivot");
        }

        // for a sorted array with pivot = 10, split point is usually 0
        assertEquals(0, p);
    }

    @Test
    void testPartitionOnEmptyArray() {
        int[] arr = {};

        // empty array case
        int p = HoareQuickSort.partition(arr, 0, -1);

        assertEquals(-1, p);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testPartitionOnGivenUnsortedArray() {
        int[] arr = {84, 3, 7, 1, 9, 6, 2, 5};

        int low = 0;
        int high = arr.length - 1;

        int pivotValue = arr[low]; // pivot = 84

        int p = HoareQuickSort.partition(arr, low, high);

        assertTrue(p >= low && p <= high);

        // left side should be <= pivot (since pivot is 84, this should be true )
        for (int i = low; i <= p; i++) {
            assertTrue(arr[i] <= pivotValue, "Left side has something bigger than pivot");
        }

        // right side should be >= pivot
        for (int i = p + 1; i <= high; i++) {
            assertTrue(arr[i] >= pivotValue, "Right side has something smaller than pivot");
        }

    }
}

