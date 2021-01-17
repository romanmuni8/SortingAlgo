package MergeSort;

public class MergeSort {
    private static void MergeSort(int [] a, int start, int end){
        System.out.println("Tryign to merge" + "Start " + start + " End " + end);
        System.out.println("The middle should be "+ (end + start)/2);
        if(start<end){
            int middle = (end + start)/2;
            MergeSort(a, start, middle);
            MergeSort(a, middle+1,end);
            Merge(a, start, middle, end);
        }

    }
    private static void Merge(int[]a, int start, int middle, int end ){
        System.out.println("Merge is called! Start is " + start+ "Middle is  " + middle + "End is  " + end );
        int i=0;  // index in left
        int j=0;  // index in right
        int k =start; // index in a
        int leftLength = middle -start +1; // middle is included in the left partition
        int rightLength = end - middle  ;
        int l [] = new int [leftLength];
        int r [] = new int [rightLength];


        for( int x = start;x<=middle; x++){
            l[i]=a[x];
            i++;
        }
        for( int y = middle+1; y<=end;y++ ){
            r[j] = a[y];
            j++;
        }
        i=0;
        j=0;
        while(i<leftLength && j <rightLength){
            if(l[i]<=r[j]){
                a[k] = l[i];
                k++;
                i++;
            }else{
                a[k] = r[j];
                k++;
                j++;
            }
        }
        while(i<leftLength){
            a[k]= l[i];
            i++;
            k++;
        }
        while(j<rightLength){
            a[k] = r[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        //int [] a = {3,5,1,0,2,7,10,9,4,8};
        int [] a = {2,1};
        MergeSort(a,0,a.length-1);
        for( int i = 0 ; i<a.length; i++){
            System.out.println(a[i]);
        }

    }
}
