package HW2;

public class MergeTwoSortedArrays {
    public static int[] merge(int[] A, int[] B) {
        // Implementation of merge logic goes here
        // (e.g., using two pointers and a result array)
        int i = 0, j = 0, k = 0;
        int[] merged = new int[A.length + B.length];

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                merged[k++] = A[i++];
            } else {
                merged[k++] = B[j++];
            }
        }

        while (i < A.length) {
            merged[k++] = A[i++];
        }

        while (j < B.length) {
            merged[k++] = B[j++];
        }

        return merged;
    }
}
