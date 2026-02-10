package HW2;

public class LomutoQuickSort {

    // Lomuto partition:
    // pivot = arr[high]
    // return the final index of pivot
    public static int partition(int[] arr, int low, int high) {

        // if array is empty, nothing to do
        if (low > high) return -1;

        int pivot = arr[high];

        // i tracks the end of the small or equal zone
        int i = low - 1;

        // j scans the array and move <= pivot to the left
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap current element into the <= pivot zone
                swap(arr, i, j);
            }
        }

        // drop pivot right after the <= pivot zone
        swap(arr, i + 1, high);
        return i + 1;
    }

    // quicksort using Lomuto partition
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is where pivot ends up
            int pi = partition(arr, low, high);

            // If pi == -1, it means the range was empty, so we stop
            if (pi == -1) return;

            // Sort left side
            quickSort(arr, low, pi - 1);

            // Sort right side
            quickSort(arr, pi + 1, high);
        }
    }

    // swap function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
