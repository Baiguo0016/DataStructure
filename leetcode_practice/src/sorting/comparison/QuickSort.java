package sorting.comparison;
import java.util.Random;

public class QuickSort {


    static int partition(int[] a, int low, int high) {
        int key = a[high];
        int i = low - 1; // The known number which is ensured to be smallest
        for (int j = low; j < high; j++) {
            if (a[j] < key) {
                i++;
                int k = a[i];
                a[i] = a[j];
                a[j] = k;
            }
        }

        int k = a[i + 1];
        a[i + 1] = key;
        a[high] = k;
        return i + 1;
    }

    static int randomizedPartition(int[] a, int low, int high) {
        int i = (low + high) / 2;
        int k = a[i];
        a[i] = a[high];
        a[high] = k;
        return partition(a, low, high);
    }

    static void quickSort (int[] a, int left, int right){
        if (left < right) {
            int correctPosition = randomizedPartition(a, left, right);
            quickSort(a, left, correctPosition - 1);
            quickSort(a, correctPosition +1, right);
        }
    }


    public static void main (String[] args) {
        int[] a1 = {0, 1, 3, 5};
        int[] a2 = {2, 4, 9, 6, 10, 0, 7, 13, -2};
        quickSort(a2, 0, a2.length - 1);
        for (int i = 0; i < a2.length; i ++) {
            System.out.print(a2[i] + " | ");
        }
    }
}
