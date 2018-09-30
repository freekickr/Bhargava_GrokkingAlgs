package _01_Introduction;

/* Binary search performs only with sorted arrays, and before we start to search an index of a number, we need to sort our array */

import java.util.Arrays;

public class BinarySearch {
    private static final int[] ARRAY = new int[] {1, 2, 5, 3, 7, 1, 4, 7, 1, 77, 9, 10, 11, 15, 12, 44, 13, 6};
    private static final int NUM_TO_FIND = 4;

    public static void main(String[] args) {
        System.out.println(binarySearch(ARRAY, NUM_TO_FIND));
    }

    public static int binarySearch(int[] arr, int num) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high)/2;
            if (arr[mid] == num)
                return mid;
            if (mid > num)
                high = mid - 1;
            else
                low = mid - 1;
        }
        return -1;
    }
}
