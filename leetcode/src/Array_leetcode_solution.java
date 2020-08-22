import java.util.ArrayList;
import java.util.List;

public class Array_leetcode_solution {
    private Array_leetcode_solution(){};
    public static void main(String[] args) {
        // for test
        System.out.println(Main.minWindow("ADOBECODEBANC","ABC"));

    }

    //283
    public void moveZeroes(int[] nums) {


        int z = 0;
        int l = 0;
        while(l<nums.length){
            if(nums[l] != 0){
                nums[z] = nums[l];
                z++;
            }
            l++;
        }
        for(int i = z; i< nums.length;i++){
            nums[i] = 0;
        }

    }


    //27
    public int removeElement(int[] nums, int val) {

        int k = 0;
        int l = 0;

        while(l< nums.length){
            if(nums[l] !=val){
                nums[k] = nums[l];
                k++;
            }
            l++;

        }

        return k;
    }

    //26
    public int removeDuplicates(int[] nums) {

        int l = 1;
        int u = 0;
        while (l< nums.length){
            if (nums[l] != nums[u]){
                u++;
                nums[u] = nums[l];
            }
            l++;
        }

        return (u+1);
    }

    //80
    public int removeDuplicates80(int[] nums) {


        int k = 1;
        int l = 2;
        while(l<nums.length){

            if(nums[l] != nums[k] || (nums[l] != nums[k-1])){
                k++;
                nums[k] = nums[l];
            }
            l++;
        }
        return (k+1);
    }

    //75

    public void sortColors(int[] nums) {

        int l =0;
        int r = nums.length;
        int i = 0;

        while(i<r){
            if (nums[i] == 0 ){
                int t = nums[l];
                nums[l] = nums[i];
                nums[i] = t;
                l++;
                i++;


            }else if(nums[i] == 2){
                int t = nums[r-1];
                nums[r-1] = nums[i];
                nums[i] = t;
                r--;

            }else {
                i++;
            }

        }

    }


    //167
    public int[] twoSum(int[] numbers, int target) {


        int l =0;
        int r = numbers.length-1;

        while(l<r){
            if((numbers[l] + numbers[r])==target){
                return new int[]{l+1,r+1};
            }else if (numbers[l]+ numbers[r] < target){
                l++;
            }else {
                r--;
            }
        }

        return new int[]{0,0};
    }

    //209

    public int minSubArrayLen(int s, int[] nums) {

        int min_l = nums.length;
        int sum = 0;
        int l=0;
        int r = -1;
        while(l<nums.length){
            if(sum<s && r<(nums.length-1)){
                sum += nums[++r];
            }else{
                sum -= nums[l];
                l++;
            }

            if(sum>=s){
                min_l = Math.min(min_l,r-l+1);
            }

        }
        if(min_l==nums.length){
            return 0;
        }else {
            return min_l;

        }
    }

    //3
    public static int lengthOfLongestSubstring(String s) {
        int l =0,r = -1;
        int res = 0;
        int[] freq = new int[256];

        while (l<s.length()){

            if(r+1< s.length()&& freq[s.charAt(r+1)] == 0){

                freq[s.charAt(r+1)] = 1;
                r++;
                res = Math.max(res,r-l+1);
            }else {
                freq[s.charAt(l)] = 0;
                l++;
            }
        }
        return res;


    }

    // 11
    public static int maxArea(int[] height) {

        int max_c = 0;
        int l = 0,r = height.length-1;


        while (l<r){
            max_c = Math.max(max_c,Math.min(height[l],height[r])*(r-l));


            if(height[l] >= height[r]){
                r--;
            }else{
                l++;
            }

        }
        return  max_c;
    }

    //76
    public static String minWindow(String s, String t) {

        int start = -1;
        int[] char_count = new int[100];
        int l=0,r = 0;
        int count = t.length();
        int min_len = s.length()+1;

        for (int i =0; i<t.length();i++){
            char_count[t.charAt(i) - 'A'] --;
        }
        while (l<s.length()){
            if (count > 0 && r < s.length()){
                if (char_count[s.charAt(r)-'A']<0){
                    count--;
                }
                char_count[s.charAt(r) - 'A'] ++;
                r++;
            }else {
                if (min_len>(r-l)&&count == 0){
                    min_len = r-l;
                    start = l;
                }
                char_count[s.charAt(l)-'A']--;
                if (char_count[s.charAt(l)-'A'] <0 ){
                    count++;
                }
                l++;
            }
        }
        if (start>=0){
            return s.substring(start,start+min_len);

        }else {
            return "";
        }
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i_1 = 0;
        int i_2 = 0;
        int l = 0;
        int[] new_nums = new int[m+n];
        while (i_1< m || i_2<n){
            if(i_1<=m && i_2 >n){
                new_nums[l] = nums1[i_1];
                i_1++;
            }else if(i_2<=n && i_1>m){
                new_nums[l] = nums2[i_2];
                i_2++;
            }else {
                if(nums1[i_1] < nums2[i_2]){
                    new_nums[l] = nums2[i_1];
                    i_1++;

                } else {
                    new_nums[l] = nums2[i_2];
                    i_2++;
                }
            }
            l++;

        }
        for(int i = 0;i<new_nums.length;i++){
            System.out.println(new_nums[i]);
            nums1[i] = new_nums[i];
        }

    }

    public boolean isPalindrome(String s) {
        //97-122
        String s_lower = s.toLowerCase();
        int l = 0;
        int r = s_lower.length()-1;

        while (l<=r){
            if (Main.isnumberorcharacter(s_lower.charAt(l)) && Main.isnumberorcharacter(s_lower.charAt(r))){
                if(s_lower.charAt(l) != s_lower.charAt(r)){
                    return false;
                }else {
                    l++;
                    r--;
                }
            }else if(!Main.isnumberorcharacter(s_lower.charAt(l))){
                l++;
            }else {
                r--;
            }
        }
        return true;

    }

    public static boolean isnumberorcharacter(char c){
        if((96<c&&c<123 )){
            return true;
        }else if(47<c && c<58){
            return true;
        }else {
            return false;
        }

    }

    //215
    public static int findKthLargest(int[] nums, int k) {

    // 可以直接用优先队列 更简单

        int start = 0;
        int end = nums.length-1;
        while (start<=end){
            int l = start;
            int r = end;
            int comp_i = l;
            int comp = nums[l++];

            while (l<r){


                if (nums[l]>=comp && nums[r] < comp){

                    int t = nums[l];
                    nums[l] = nums[r];
                    nums[r] = t;
                    l++;
                    r--;
                }else {
                    if(nums[l]<comp){
                        l++;
                    }
                    if(nums[r] >= comp){
                        r--;
                    }
                }

            }
            if(l<nums.length && nums[l] < comp){
                int t = nums[l];

                nums[l] = comp;
                nums[comp_i] = t;
                l++;
            }else {
                int t = nums[l-1];

                nums[l-1] = comp;
                nums[comp_i] = t;
            }


            if((l-1) == (nums.length-k)){
                return comp;
            }else if((l-1) < (nums.length-k)){
                start = l;
            }else {
                end = l-2;
            }


        }

        if(nums.length == 1){
            return nums[0];
        }else {
            return 0;
        }
    }

    //345
    public static String reverseVowels(String s) {

        ArrayList<Character> v = new ArrayList<Character>();
        v.add('a');
        v.add('e');
        v.add('i');
        v.add('o');
        v.add('u');

        int l = 0,r = s.length();
        char[] news = s.toCharArray();

        while (l<r){
            if(v.contains(news[l]) && v.contains(news[r-1])){
                char t = news[l];
                news[l] = news[r-1];
                news[r-1] = t;
                l++;
                r--;

            }else{

                if (!v.contains(news[l])){
                    l++;
                }
                if (!v.contains(news[r-1])){
                    r--;
                }
            }
        }

        return String.valueOf(news);
    }

    //438
    public static List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> res = new ArrayList<>();

        int[] char_count = new int[26];
        int count = p.length();

        for (char c : p.toCharArray()) {
            char_count[c - 'a']--;
        }

        int len = 0;
        int start = 0;
        for (int i = 0; i<s.length();i++){

            if (i<p.length()){

                if (char_count[s.charAt(i)-'a']<0){
                    count --;
                }
                char_count[s.charAt(i) - 'a']++;

            }else {

                if (count == 0){
                    res.add(start);
                }

                char_count[s.charAt(start)-'a']--;

                if (char_count[s.charAt(start)-'a']<0){
                    count ++;
                }

                if (char_count[s.charAt(i)-'a']<0){
                    count --;
                }
                char_count[s.charAt(i) - 'a']++;

                start++;


            }




        }
        if (count == 0){
            res.add(start);
        }



        return res;

    }
}
