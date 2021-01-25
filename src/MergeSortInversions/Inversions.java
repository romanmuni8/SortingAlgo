package MergeSortInversions;
import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (left>=right) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave+1, right);
        merge(a,b, left, ave, right);
        return numberOfInversions;
    }
    private static long merge(int[]a, int []b, int left , int ave, int right){
        for( int j = 0; j < a.length;j++ ){
            b[j] = a[j];
        }

        int i = left; // we start merging from this position
        int r = ave+1;
        int l = left;
        while( r <= right  && l <=ave){ // when both right and left have elements to compare.
            if(b[l]<= b[r]){
                a[i] = b[l];
                i++;
                l++;
            }else{
                a[i] = b[r];
                i++;
                r++;
            }
        }
        while(r<=ave){
            a[i] = b[r];
            i++;
            r++;
        }
        while(l<=ave){
            a[i] = b[l];
            i++;
            l++;
        }
        while(r<=right){
            a[i] = b[r];
            i++;
            r++;
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        getNumberOfInversions(a, b, 0, a.length-1);

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}


