package II_SelectionSort;

/* Selection sort of an array in Java. Every iteration we put the smallest number to the beginning of the part we work with */

public class SelectionSort {
    private static final int[] ARRAY = new int[] {1, 2, 5, 3, 7, 1, 4, 7, 1, 77, 9, 10, 11, 15, 12, 44, 13, 6};

    public static void main(String[] args) {
        selectionSort(ARRAY);
        for (int i : ARRAY) {
            System.out.print(i + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        int temp, min;
        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
