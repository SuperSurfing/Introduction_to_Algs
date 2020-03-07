import java.util.Arrays;

public class PriorityQueue {
    private int heapSize = 0;
    private int[] A;

    public PriorityQueue(int length) {
        A = new int[length];
    }

    public PriorityQueue(int[] A, int length) {
        buildMaxHeap(A);
        this.A = new int[length];
        System.arraycopy(A, 0, this.A, 0, A.length);
    }

    private int swap(int a, int b) {
        return a;
    }

    private int parent(int i) {
        return (i-1) >> 1;
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

    private int heapMaximum(int[] A) {
        return A[0];
    }

    public int heapExtractMax(int[] A) {
        if (heapSize < 1)
            throw new IndexOutOfBoundsException();
        int max = A[0];
        A[0] = A[heapSize-1];
        heapSize--;
        maxHeapify(A, 0);
        return max;
    }

    public void heapIncreaseKey(int[] A, int i, int key) {
        if (key < A[i])
            throw new IllegalArgumentException();
        while (i > 0 && A[parent(i)] < key) {
            A[i] = A[parent(i)];
            i = parent(i);
        }
        A[i] = key;
    }

    public void maxHeapInsert(int key) {
        A[heapSize] = key;
        heapSize++;
        heapIncreaseKey(A, heapSize - 1, key);
    }

    public void buildMaxHeap(int[] A) {
        heapSize = A.length;
        for (int i = (A.length - 1) >> 1; i >= 0; i--) {
            maxHeapify(A, i);
        }
    }

    public int[] getPQ() {
        return A;
    }

    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2, 16, 9,10, 14, 8, 7};
        System.out.println(Arrays.toString(A));
        PriorityQueue ob = new PriorityQueue(A, 2 * A.length);
        ob.maxHeapInsert(15);
        System.out.println(Arrays.toString(ob.getPQ()));
    }
}
