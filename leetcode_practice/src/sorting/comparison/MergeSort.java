package sorting.comparison;

/**
 * Merge Sort, use divide and conquer
 * Break the problem into two or more subproblems and solve the subproblems recursively
 * And then combine these solutions to create a solution to the original problem
 */
public class MergeSort {

    static boolean isSmallEnough(int n, int threshold) {
        return n <= threshold;
    }

    static int[] merge(int[] a1, int[] a2) {
        int i= 0, j = 0;
        int[] result = new int[a1.length + a2.length];
        int index = 0;
        while (i < a1.length && j < a2.length){
//            System.out.println(i + "|" + j);
            if(a1[i] <= a2[j]){
                result[index] = a1[i];
                i++;
            } else {
                result[index] = a2[j];
                j++;
            }
            index++;
        }


        while (index < a1.length + a2.length && i < a1.length) {
//            System.out.println(index);
            result[index] = a1[i];
            i++;
            index++;
//            System.out.println(index);
        }


        while (index < a1.length + a2.length && j < a2.length) {
            result[index] = a2[j];
            j++;
            index++;
        }
        return result;
    }


    static int[] divideAndConquer(int[] a, int threshold) {
        int[] sol = a;
        if (isSmallEnough(a.length, threshold)) {
            InsertionSort.IncAlg(a);
        } else {
            int leftLength = a.length / 2;
            int rightLength = a.length - leftLength;
            int[] a1 = new int[leftLength];
            int[] a2 = new int[rightLength];
            for (int i = 0; i < leftLength; i ++) {
                a1[i] = a[i];
            }

            int a2Index = 0;
            for (int j = leftLength; j < a.length; j ++) {
                a2[a2Index] = a[j];
                a2Index++;
            }

            int[] sol1 = divideAndConquer(a1, threshold);
            int[] sol2 = divideAndConquer(a2, threshold);
            sol = merge(sol1, sol2);
        }
        return sol;
    }

    public static void main (String[] args) {
        int[] a1 = {0, 1, 3, 5};
        int[] a2 = {2, 4, 9, 6};
        int[] result;
        result = divideAndConquer(a2, 1);
        for (int i = 0; i < result.length; i ++) {
            System.out.print(result[i] + " | ");
        }
    }
}
