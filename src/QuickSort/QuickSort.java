package QuickSort;

public class QuickSort {
    private static void quickSort(int [] array, int p, int r){
        if( p<r ){
         int q = partition(array, p,r);
         quickSort(array, p, q-1);
         quickSort(array, q+1, r);
        }



    }

    private static int partition(int []array, int p, int r){
        int i = p-1;
        int j = p;
        while(j<r){
            if(array[j]>=array[r]){
                j++;
            }else{
                i++;
                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        i++;
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;

        return i+1;

    }



    public static void main(String[] args) {
        int [] array = {7,2,1};
        quickSort(array, 0, array.length-1);

        for (int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
