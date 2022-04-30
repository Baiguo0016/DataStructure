package search.comparison;

public class BinarySearch {
    static int binarySearchMethod(int[] a, int target){
        int left = 0;
        int right = a.length - 1;
        int middle = (left + right) / 2;
        while (left <= right) {
            if(a[middle] < target) {
                left = middle + 1;
            }

            if (a[middle] > target) {
                right = middle - 1;
            }

            if (a[middle] == target) {
                return middle;
            }
        }
        return -1;
    }

    public static void main (String[] args){
        int[] a2 = {2, 4, 9, 6};
        int result = binarySearchMethod(a2, 4);
        System.out.println(result);
    }
}
