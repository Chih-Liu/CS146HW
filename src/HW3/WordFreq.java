package HW3;

/* WordFreq stores a phrase and its frequency. */
public class WordFreq {
    String word;  // the phrase
    int frequency;  // how many times it appears

    // constructor to create a WordFreq object
    public WordFreq(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "\"" + word + "\"(" + frequency + ")";
    }
}

/* Build a max heap from WordFreq array. */
class Main {
    // swap two elements in the array
    private static void swap(WordFreq[] A, int i, int j) {
        WordFreq temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    // fix the heap property at index i
    private static void maxHeapify(WordFreq[] A, int heapSize, int i) {
        while (true) {
            int left = 2 * i + 1;  // left child
            int right = 2 * i + 2;  // right child
            int largest = i;  // assume current is largest

            if (left < heapSize && A[left].frequency > A[largest].frequency) {
                largest = left;
            }
            if (right < heapSize && A[right].frequency > A[largest].frequency) {
                largest = right;
            }

            if (largest == i) return;

            swap(A, i, largest);
            i = largest;
        }
    }

    private static void buildMaxHeap(WordFreq[] A) {
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            maxHeapify(A, A.length, i);
        }
    }

    private static void printArray(WordFreq[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.println("A[" + i + "] = " + A[i]);
        }
    }
    // Main: create array, build heap, print result
    public static void main(String[] args) {
        WordFreq[] A = new WordFreq[] {
                new WordFreq("happy", 400),
                new WordFreq("satisfied", 100),
                new WordFreq("neutral", 300),
                new WordFreq("would buy again", 200),
                new WordFreq("terrible", 160),
                new WordFreq("inconvenient", 900),
                new WordFreq("difficult to use", 100),
                new WordFreq("easy to use", 140),
                new WordFreq("would recommend to friends", 800),
                new WordFreq("visit the store", 700)
        };

        buildMaxHeap(A);

        System.out.println("Heapified order:");
        printArray(A);
    }
}
