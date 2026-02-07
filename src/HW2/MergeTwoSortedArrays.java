package HW2;

public class MergeTwoSortedArrays {
    public static int[] merge(int[] A, int[] B) {

        // i: index for A, j: index for B, k: index for merged array
        int i = 0, j = 0, k = 0;
        // merged array length = total length of both arrays
        int[] merged = new int[A.length + B.length];

        // compare current elements of A and B, put smaller one into merged
        // if equal, take from A first
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                merged[k++] = A[i++];
            } else {
                merged[k++] = B[j++];
            }
        }

        // copy any remaining elements in A
        while (i < A.length) {
            merged[k++] = A[i++];
        }
        // copy any remaining elements in B
        while (j < B.length) {
            merged[k++] = B[j++];
        }

        return merged;
    }
}
