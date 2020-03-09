public class RandomizedSelect {
    private static int swap(int a, int b) {
        return a;
    }

    private static int randomizedPartition(int[] A, int lo, int hi) {
        int r = lo + (int) (Math.random() * (hi - lo + 1));
        A[hi] = swap(A[r], A[r] = A[hi]);
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

    public static int randomizedSelect(int[] A, int lo, int hi, int i) {
        if (lo == hi) return A[lo];
        int p = randomizedPartition(A, lo, hi);    // absolute position
        int r = p - lo;    // relative position
        if (i == r + 1)     // the pivot value is the answer
            return A[p];
        else if (i < r + 1)
            return randomizedSelect(A, lo, p-1, i);
        else
            return randomizedSelect(A, p+1, hi, i-r-1);
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            int[] A = {2, 8, 7, 1, 3, 5, 6, 4};
            if (i == randomizedSelect(A, 0, A.length-1, i))
                System.out.println("Succeeded!");
            else
                System.out.println("Failed!");
        }
    }
}
