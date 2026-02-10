package HW2;

public class HoareQuickSort {

        // Hoare partition:
        // pivot = arr[low]
        // returns split index j
        public static int partition(int[] arr, int low, int high) {

            // if array is empty
            if (low > high) return -1;

            int pivot = arr[low];
            int i = low - 1;
            int j = high + 1;

            while (true) {
                // move i right until arr[i] >= pivot
                do {
                    i++;
                } while (arr[i] < pivot);

                // move j left until arr[j] <= pivot
                do {
                    j--;
                } while (arr[j] > pivot);

                // if left and right crossed, no swapping
                if (i >= j) return j;
                // swap the two wrong side elements
                swap(arr, i, j);
            }
        }

        // Hoare partition
        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int p = partition(arr, low, high);
                if (p == -1) return;

                // Hoare uses (low..p) and (p+1..high)
                quickSort(arr, low, p);
                quickSort(arr, p + 1, high);
            }
        }
        // swap function
        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
