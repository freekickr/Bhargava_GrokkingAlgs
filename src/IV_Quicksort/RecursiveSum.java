package IV_Quicksort;

/* Recursion way to count a sum of an array from some index to the end and search for the largest number */

public class RecursiveSum {
    private static final int[] ARRAY = new int[] {1, 2, 5, 3, 7, 1, 4, 7, 1, 77, 9, 10, 11, 15, 12, 44, 13, 6};

    public static void main(String[] args) {
        System.out.println(sum(ARRAY, 0));
        System.out.println(largestOne(ARRAY));
    }

    private static int sum(int[] array, int from) {
        int res = array[from];
        if (from == array.length-1)
            return array[array.length-1];
        else {
            res = res + sum(array, from + 1);
            return res;
        }
    }

    private static int largestOne(int[] array) {
        int res = array[0];
        for (int i = 0; i < array.length; i++)
            if (array[i] > res)
                res = array[i];
        return res;
    }
}
