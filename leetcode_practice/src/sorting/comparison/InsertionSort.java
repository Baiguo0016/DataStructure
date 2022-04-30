package sorting.comparison;


/**
 * @Date: 2022-04-30
 * @Author: Yuqin Cui
 * InsertionSort: use a[j] value as the key and compare with previous element.
 * If it is smaller than its previous element, copy its previous value to itself iteratively, until find the correct
 * position to put key
 * 1 4 3 2 ->
 * 1 4 4 2 ->
 * 1 3 4 2 ->
 * 1 3 4 4 ->
 * 1 3 3 4 ->
 * 1 2 3 4
 * Done
 */
public class InsertionSort {


     static void IncAlg(int[] a) {
        int i;
        int k;
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
        }
    }

    static int[] testArray1 = {1, 6, 2, 3, 4};


    public static void main(String [] args) {
        IncAlg(testArray1);

        for (int i = 0; i < testArray1.length; i++) {
            System.out.println(testArray1[i] +  " | ");
        }

//        System.out.println("Not implement");
    }
}
