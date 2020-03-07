import java.util.Arrays;

public class HeapSort {
    private int heapSize = 0;
    private int swap(int a, int b) {
        return a;
    }

    private int leftChild(int i) {
        return i << 1;
    }

    private int rightChild(int i) {
        return (i << 1) + 1;       // the priority of '+" is greater than '<<'
    }

    private void maxHeapify(int[] A, int i) {
        int largest = 0;
        int l = leftChild(i);
        int r = rightChild(i);

        if (l < heapSize && A[l] > A[i])
            largest = l;
        else
            largest = i;

        if (r < heapSize && A[r] > A[largest])
            largest = r;

        if (largest != i) {
            A[i] = swap(A[largest], A[largest] = A[i]);
            maxHeapify(A, largest);
        }
    }

    private void buildMaxHeap(int[] A) {
        heapSize = A.length;
        for (int i = (A.length - 1) >> 1; i >= 0; i--) {
            maxHeapify(A, i);
        }
    }


    public void sort(int[] A) {
        buildMaxHeap(A);
        System.out.println(Arrays.toString(A));
        for (int i = A.length - 1; i > 0; i--) {
            A[i] = swap(A[0], A[0] = A[i]);
            heapSize--;
            maxHeapify(A, 0);
        }
    }

    public static void main(String args[]) {
        int[] A = {4, 1, 3, 2, 16, 9,10, 14, 8, 7};
        System.out.println(Arrays.toString(A));
        HeapSort ob = new HeapSort();
        ob.sort(A);
        System.out.println(Arrays.toString(A));
    }
}
