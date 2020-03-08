import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k+1];
        for (int i = 0; i < A.length; i++)
            C[A[i]]++;
        // C[i] now contains the number of elements equal to i.

        for (int i = 1; i <=k; i++)
            C[i] += C[i-1];
        // C[i] now contains the number of elements less than or equal i.

        for (int j = A.length-1; j >=0; j--) {
            B[C[A[j]]-1] = A[j];     // find the correct position to insert into
            C[A[j]]--;
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 3, 0, 2, 3, 0, 3};
        System.out.println(Arrays.toString(A));
        int[] B = new int[A.length];
        countingSort(A, B, 5);
        System.out.println(Arrays.toString(B));
    }
}
