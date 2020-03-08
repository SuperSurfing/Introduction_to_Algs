import java.util.Arrays;
import java.util.PriorityQueue;

public class BucketSort {
    public static  void bucketSort(double[] A) {
        int n = A.length;
        PriorityQueue[] buckets = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            int j = (int)(A[i] * n);
            if (buckets[j] == null)
                buckets[j] = new PriorityQueue();
            buckets[j].offer(A[i]);
        }

        // concatenate
        for (int i = 0, j = 0; j < buckets.length; j++) {
            while (buckets[j] != null && buckets[j].peek() != null )
                A[i++] = (double)buckets[j].poll();
        }
    }

    public static void main(String[] args) {
        double[] A = {.78, .17, .39, .26, .72, .94, .21, .12, .23, .68};
        System.out.println(Arrays.toString(A));
        bucketSort(A);
        System.out.println(Arrays.toString(A));
    }
}
