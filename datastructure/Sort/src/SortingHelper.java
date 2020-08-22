public class SortingHelper {
    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for(int i = 1;i< arr.length;i++){
            if(arr[i-1].compareTo(arr[i])>0){


                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) {
        long starttime = System.nanoTime();

        if(sortname.equals("InsertionSort")){
            InsertionSort.sort(arr);
        }else if(sortname.equals("InsertionSort2")){
            InsertionSort.sort2(arr);

        }





        long endtime = System.nanoTime();

        double time = (endtime-starttime)/1000000000.0;


        if(!SortingHelper.isSorted(arr)){
            throw new RuntimeException("SelectionSort failed");
        }
        System.out.println(time+" s");
    }
}
