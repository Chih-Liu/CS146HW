package HW1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ArrayUtilsTest {
    @Test
    public void testMergeBasicCase() {
        int[] A = {1, 3, 5};
        int[] B = {2, 4, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] actual = MergeTwoSortedArrays.merge(A, B);
        Assertions.assertArrayEquals(expected, actual, "Should merge two non-empty sorted arrays correctly.");
    }

    @Test
    public void testMergeWithEmptyFirstArray() {
        int[] A = {};
        int[] B = {2, 4, 6};
        int[] expected = {2, 4, 6};
        int[] actual = MergeTwoSortedArrays.merge(A, B);
        Assertions.assertArrayEquals(expected, actual, "Should return the second array if the first is empty.");
    }

    @Test
    public void testMergeWithEmptySecondArray() {
        int[] A = {1, 3, 5};
        int[] B = {};
        int[] expected = {1, 3, 5};
        int[] actual = MergeTwoSortedArrays.merge(A, B);
        Assertions.assertArrayEquals(expected, actual, "Should return the first array if the second is empty.");
    }

    @Test
    public void testMergeWithBothEmptyArrays() {
        int[] A = {};
        int[] B = {};
        int[] expected = {};
        int[] actual = MergeTwoSortedArrays.merge(A, B);
        Assertions.assertArrayEquals(expected, actual, "Should return an empty array if both are empty.");
    }

    @Test
    public void testMergeWithDuplicates() {
        int[] A = {1, 2, 4};
        int[] B = {2, 3, 4, 5};
        int[] expected = {1, 2, 2, 3, 4, 4, 5};
        int[] actual = MergeTwoSortedArrays.merge(A, B);
        Assertions.assertArrayEquals(expected, actual, "Should handle duplicate elements correctly.");
    }

    @Test
    public void testMergeWithDifferentLengths() {
        int[] A = {1, 7};
        int[] B = {2, 3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        int[] actual = MergeTwoSortedArrays.merge(A, B);
        Assertions.assertArrayEquals(expected, actual, "Should merge arrays of different lengths.");
    }

}
