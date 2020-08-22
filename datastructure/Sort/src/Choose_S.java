
/*
    choose search
 */
public class Choose_S {


    public static <E extends Comparable<E>> E[] Choose_search(E[] nums){
        for(int i = 0; i< nums.length; i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[i] .compareTo(nums[j])>0){
                    E t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Character[] test_nums = {'a','w','a','q','h','v','i','c'};
//        {23,3,6,4,5,1,6,45,3,456,12,4};
        Character[] Sorted_nums = Choose_search(test_nums);
        for(int i = 0; i< Sorted_nums.length;i++){
            System.out.print(Sorted_nums[i]+", ");
        }
    }
}
