import java.util.Arrays;

public class QuickSort {
    private static int swap(int a, int b) {
        return a;
    }
    private static int partition(int[] A, int lo, int hi) {
        int pivot = A[hi];
        int i = 0;
        for (int j = 0; j < hi; j++) {    // double pointers, four parts
            if (A[j] < pivot) {
                A[i] = swap(A[j], A[j] = A[i]);
                i++;
            }
        }
        A[i] = swap(A[hi], A[hi] = A[i]);
        return i;
    }
    private static void quickSort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int p = partition(A, lo, hi);
            quickSort(A, lo, p - 1);
            quickSort(A, p + 1, hi);
        }
    }

    public static void sort(int[] A) {
        quickSort(A, 0, A.length-1);
    }

    public static void main(String [] args) {
        int[] A = {2, 8, 7, 1, 3, 5, 6, 4};
        System.out.println(Arrays.toString(A));
        sort(A);
        System.out.println(Arrays.toString(A));
    }
}
