import java.util.Arrays;

public class MaxSubarray {
    private static int findMaxCrossingSubarray(int[] A, int[] crossIndexes, int mi) {
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = mi;
        int sum = 0;
        for (int i = mi; i >= crossIndexes[0]; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int maxRight = mi + 1;
        sum = 0;
        for (int j = mi + 1; j <= crossIndexes[1]; j++) {
            sum += A[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        crossIndexes[0] = maxLeft;
        crossIndexes[1] = maxRight;
        return leftSum + rightSum;
    }

    public static int findMaxSubarray(int[] A, int[] indexes) {
        if (indexes[0] == indexes[1]) return A[0];

        int mi = (indexes[0] + indexes[1]) / 2;

        int[] leftIndexes = new int[2];
        leftIndexes[0] = indexes[0];
        leftIndexes[1] = mi;
        int leftSum = findMaxSubarray(A, leftIndexes);

        int[] rightIndexes = new int[2];
        rightIndexes[0] = mi + 1;
        rightIndexes[1] = indexes[1];
        int rightSum = findMaxSubarray(A, rightIndexes);

        int[] crossIndexes = indexes.clone();
        int crossSum = findMaxCrossingSubarray(A, crossIndexes, mi);

        if (leftSum >= rightSum && leftSum >= crossSum) {
            indexes[0] = leftIndexes[0];
            indexes[1] = leftIndexes[1];
            return leftSum;
        }
        else if (rightSum >= leftSum && rightSum >= crossSum) {
            indexes[0] = rightIndexes[0];
            indexes[1] = rightIndexes[1];
            return rightSum;
        }
        else {
            indexes[0] = crossIndexes[0];
            indexes[1] = crossIndexes[1];
            return crossSum;
        }
    }

    public static void main(String[] args) {
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] indexes = {0, A.length - 1};
        int maxSum = findMaxSubarray(A, indexes);
        System.out.println(maxSum);
        System.out.println(Arrays.toString(indexes));
    }
}
