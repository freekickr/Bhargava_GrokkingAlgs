package II_Chapter;

import java.util.Arrays;

public class SelectionSort {
    private static final int[] ARRAY = new int[] {1, 2, 5, 3, 7, 1, 4, 7, 1, 77, 9, 10, 11, 15, 12, 44, 13, 6};

    public static void main(String[] args) {
        selectionSort(ARRAY);
        for (int i : ARRAY) {
            System.out.print(i + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
