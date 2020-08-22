public class InsertionSort {
    private InsertionSort(){}
    public static <E extends Comparable<E>> void sort(E[] arr){
        for(int i =0; i<arr.length;i++){
            for(int j=i;j-1>=0;j--){
                if(arr[j].compareTo(arr[j-1])<0){
                    E t = arr[j];
                    arr[j]= arr[j-1];
                    arr[j-1] = t;
                }else{
                    break;
                }
            }
        }
    }


    public static <E extends Comparable<E>> void sort2(E[] arr){
        for(int i =0; i<arr.length;i++){
            E cur = arr[i];

            for(int j=i;j-1>=0;j--){

                if(cur.compareTo(arr[j-1])<0){
                    arr[j]= arr[j-1];
                }else{
                    arr[j] =cur;
                    break;
                }




            }
        }
    }

    public static void main(String[] args){



        int[] dataSize = {10000,100000};

        for (int n:dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
            SortingHelper.sortTest("InsertionSort2",arr);
        }
    }
}
