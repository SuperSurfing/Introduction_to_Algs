import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] A) {
        if (A.length < 2) return;
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && key < A[i]) {
                A[i + 1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
