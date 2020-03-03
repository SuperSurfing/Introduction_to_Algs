import java.util.Arrays;

public class MergeSort {
    //private final static int MaxInteger = 2147483647;
    private static void merge(int[] A, int lo, int mi, int hi) {
        int n1 = mi - lo + 1;
        int n2 = hi - mi;
        int[] B = new int[n1 + 1];
        int[] C = new int[n2 + 1];
        System.arraycopy(A, lo, B, 0, n1);
        System.arraycopy(A, mi + 1, C, 0, n2);
        B[n1] = Integer.MAX_VALUE;
        C[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = lo; k <= hi; k++) {
            if (B[i] <= C[j]) {
                A[k] = B[i];
                i++;
            } else {
                A[k] = C[j];
                j++;
            }
        }
    }
//    private static void merge(int[] A, int lo, int mi, int hi) {
//        int[] B = Arrays.copyOfRange(A, lo, mi + 1);
//        int[] C = Arrays.copyOfRange(A, mi+1, hi + 1);
//        int i = 0, j = 0;
//        for (int k = lo; k <= hi; k++) {
//            if (j >= C.length || i < B.length && B[i] <= C[j]) {
//                A[k] = B[i];
//                i++;
//            } else if (i >= B.length || j < C.length) {
//                A[k] = C[j];
//                j++;
//            }
//        }
//    }

    private static void mergeSort(int[] A, int lo, int hi) {
        if (lo == hi) return;

        int mi = (lo + hi) / 2;
        mergeSort(A, lo, mi);
        mergeSort(A, mi + 1, hi);
        merge(A, lo, mi, hi);
    }

    public static void sort(int[] A) {
        if (A.length < 2) return;

        mergeSort(A, 0, A.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 4, 7, 1, 3, 2, 6};
        //System.out.println(Arrays.toString(a));
        sort(a);
        //System.out.println(Arrays.toString(a));
    }
}
