import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class Set_map_leetcode_solution {

    private Set_map_leetcode_solution(){

    };
    public static void main(String[] args) {
        // for test
        System.out.println(isHappy(2));
        System.out.println(12/10);


    }

    //349
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1_set = new HashSet<>();
        HashSet<Integer> nums2_set = new HashSet<>();

        int l= 0;
        for (int i = 0;i<nums1.length;i++){
            nums1_set.add(nums1[i]);
        }
        for (int i = 0;i<nums2.length;i++){
            nums2_set.add(nums2[i]);
        }

        for(Integer n:nums2_set){
            if (nums1_set.contains(n)){
                nums2[l] = n;
                l++;
            }
        }
        int[] res = new int[l];
        for (int i= 0;i<l;i++){
            res[i] = nums2[i];
        }

        return res;
    }

    //350
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nums2_map = new HashMap<>();
        int l= 0;

        for (int i = 0;i<nums2.length;i++){
            if (nums2_map.containsKey(nums2[i])){
                nums2_map.put(nums2[i],nums2_map.get(nums2[i])+1);

            }else {
                nums2_map.put(nums2[i],1);

            }
        }

        for(Integer n:nums1){
            if (nums2_map.containsKey(n) && nums2_map.get(n)>0){
                nums1[l] = n;
                nums2_map.put(n,nums2_map.get(n)-1);

                l++;
            }
        }
        int[] res = new int[l];
        for (int i= 0;i<l;i++){
            res[i] = nums1[i];
        }

        return res;
    }

    //451

    public static String frequencySort(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();

        for(Character c:s.toCharArray()){
            if (freq.containsKey(c)){
                freq.put(c,freq.get(c)+1);
            }else {
                freq.put(c,1);
            }
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(freq.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        char[] res = new char[s.length()];
        int l = 0;
        for (Map.Entry<Character,Integer> e:list){
            System.out.println(e.getKey()+":"+e.getValue());
            for (int i = 0; i < e.getValue();i++){
                res[l] = e.getKey();
                l++;
            }
        }
        return String.copyValueOf(res);
    }


    //202
    public static boolean isHappy(int n) {

        HashSet<Integer> record = new HashSet<>();
        int res = 0;

        while (true){

            res = 0;
            System.out.println(n);
            while (n!=0){
                res += (n%10)*(n%10);
                n = n/10;
            }
            System.out.println(res);
            if (res == 1){
                return true;
            }
            if (record.contains(res)){
                return false;
            }else {
                record.add(res);

            }
            n = res;


        }

    }
    //205
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> record = new HashMap<>();

        for(int i = 0 ;i < s.length();i++){

            if (!record.containsKey(s.charAt(i))){

                if (record.containsValue(t.charAt(i))){
                    return false;
                }
                record.put(s.charAt(i),t.charAt(i));

            }else {
                if (record.get(s.charAt(i))!= t.charAt(i)){
                    return false;
                }

            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {

        if (s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> s_tree = new HashMap<>();

        for (Character c:s.toCharArray()){
            if (s_tree.containsKey(c)){
                s_tree.put(c,s_tree.get(c)+1);
            }else {
                s_tree.put(c,1);
            }
        }

        for (Character c : t.toCharArray()){
            if (s_tree.containsKey(c) && s_tree.get(c)>0 ){
                s_tree.put(c,s_tree.get(c)-1);
            }else {
                return false;
            }
        }
        return true;

    }

    //292 没啥意义
    public boolean canWinNim(int n) {
        return (n%4!=0);
    }
}
