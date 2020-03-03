import java.util.Arrays;

public class InversionPair {
    private static int count = 0;

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
        int nB = 0, nC = 0;
        for (int k = lo; k <= hi; k++) {
            //   i      n1    j    n2
            //   |      |     |    |
            // |--------)|---------）
            // 若此时发生B[i] > C[j]，则由于B[0..i) < C[j]且C[0..j) < C[j]
            // 故与C[j]构成逆序对的元素是B[i..n1)
            if (B[i] <= C[j]) {
                A[k] = B[i];
                i++;
            } else {
                if (B[i] != Integer.MAX_VALUE)
                    count += n1 - i;
                A[k] = C[j];
                j++;
            }
        }
    }

    private static void mergeSort(int[] A, int lo, int hi) {
        if (lo == hi) return;

        int mi = (lo + hi) / 2;
        mergeSort(A, lo, mi);
        mergeSort(A, mi + 1, hi);
        merge(A, lo, mi, hi);
    }

    public static void sort(int[] A) {
        if (A.length < 2) return;

        count = 0;
        mergeSort(A, 0, A.length - 1);
    }
    public static int countInversion(int[] a) {
        int[] b = a.clone();
        sort(b);
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        int[] a = {2, 3, 8, 6, 1};
        if (5 == countInversion(a)) {
            System.out.println("Succeeded");
        } else {
            System.out.println("Failed");
        }

        int[] b = {1, 2, 3};
        if (0 == countInversion(b)) {
            System.out.println("Succeeded");
        } else {
            System.out.println("Failed");
        }
    }
}
