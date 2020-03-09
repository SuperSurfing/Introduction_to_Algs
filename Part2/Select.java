public class Select {
    private static int swap(int a, int b) {
        return a;
    }

    private static int partitionByMedian(int[] A, int lo, int hi, int pivot) {
        int k = 0;
        for (int i = lo; i <= hi; i++) {
            if (A[i] == pivot) {
                k = i;
                break;
            }

        }
        A[hi] = swap(A[k], A[k] = A[hi]);

        int i = 0;
        for (int j = 0; j <= hi; j++) {    // double pointers, three parts
            if (A[j] < pivot) {
                A[i] = swap(A[j], A[j] = A[i]);
                i++;
            }
        }
        A[i] = swap(A[hi], A[hi] = A[i]);
        return i;
    }

    private static int getMedianByInsertSort(int[] A, int lo, int hi) {
        for (int j = lo + 1; j <= hi; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && key < A[i]) {
                A[i + 1] = A[i];
                i--;
            }
            A[i+1] = key;
        }

        return A[lo + (hi - lo) / 2];
    }

    public static int select(int[] A, int lo, int hi, int i) {
        if (lo == hi) return A[lo];
        int n = hi - lo + 1;
        int m = (n % 5 == 0)? n / 5 : n / 5 + 1;
        int[] medians = new int[m];
        for (int j = 0; j < m; j++) {
            medians[j] = getMedianByInsertSort(A, lo + 5 * j, Math.min(n, lo + 5 * (j + 1)) - 1);
        }
        int j = (medians.length % 2 == 0)?medians.length / 2 : medians.length / 2 + 1;
        // the pivot is the median of medians
        int median = select(medians, 0, medians.length - 1, j);
        int p = partitionByMedian(A, lo, hi, median);    // absolute position

        int r = p - lo;    // relative position
        if (i == r + 1)     // the pivot value is the answer
            return A[p];
        else if (i < r + 1)
            return select(A, lo, p-1, i);
        else
            return select(A, p+1, hi, i-r-1);
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            int[] A = {2, 8, 7, 1, 3, 5, 6, 4};
            if (i == select(A, 0, A.length -1, i))
                System.out.println("Succeeded!");
            else
                System.out.println("Failed!");
        }
    }
}
