package IV_Quicksort;

import java.util.concurrent.ThreadLocalRandom;

/* Java realization of a Quicksort algorithm */

public class Quicksort {
    private static final int[] ARRAY = new int[20];

    public static void main(String[] args) {
        initArray();
        showArray();
        quickSort(0, ARRAY.length - 1);
        showArray();
    }

    private static void initArray() {
        int randomNum;
        for (int i = 0; i < ARRAY.length; i++) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 50);
            ARRAY[i] = randomNum;
        }
    }

    private static void showArray() {
        for (int i : ARRAY) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void quickSort(int low, int high) {
        if (low >= high)
            return;
        int a = low, b = high;
        int mid = a - (a - b)/2;
        while (a < b) {
            while (a < mid && ARRAY[a] <= ARRAY[mid])
                a++;
            while (b > mid && ARRAY[mid] <= ARRAY[b])
                b--;
            if (a < b) {
                int temp = ARRAY[a];
                ARRAY[a] = ARRAY[b];
                ARRAY[b] = temp;
                if (a == mid)
                    mid = b;
                else if (b == mid)
                    mid = a;
            }
        }
        quickSort(low, mid);
        quickSort(mid + 1, high);
    }
}
