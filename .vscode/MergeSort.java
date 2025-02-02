public class MergeSort implements SortingAlgorithm {
    public int[] sorty(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int midpoint = input.length / 2;
        int[] left = new int[midpoint];
        int[] right;
        if (input.length % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }
        for (int i = 0; i < midpoint; i++) {
            left[i] = input[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = input[midpoint + j];
        }
        int[] result = new int[input.length];
        left = sorty(left);
        right = sorty(right);
        result = merge(left, right);
        return result;
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer;
         int rightPointer;
          int resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

}
