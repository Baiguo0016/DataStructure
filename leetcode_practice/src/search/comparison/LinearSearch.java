package search.comparison;

public class LinearSearch {
    static int linearSearhMethod(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main (String[] args){
        int[] a2 = {2, 4, 9, 6};
        int result = linearSearhMethod(a2, 4);
        System.out.println(result);
    }
}
