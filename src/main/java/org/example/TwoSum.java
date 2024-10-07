package org.example;


import java.util.*;

/**
* <p> Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Can you come up with an algorithm that is less than O(n2) time complexity?
*
*/
public class TwoSum {

    public static void main(String [] args ){
        int[] nums1 = {2,11,15,7};
        int[] nums2 = {3,2,4};
        int[] nums3 = {3,3};
        int [] result = new TwoSum().twoSumHashMap(nums1,9);
        for (int i : result)System.out.print(i + " ");

    }

    //O nlog(n)
    public int[] twoSum(int[] nums, int target) {
         int [] result = new int[2];
        List<IndexValue> aux = new ArrayList<>();

        for(int i= 0; i < nums.length;i++){
            aux.add(new IndexValue(i, nums[i]));
        }
        //aux.sort(Comparator.comparingInt(IndexValue::getValue));
        aux.sort((iv1, iv2) -> Integer.compare(iv1.getValue(), iv2.getValue()));
         int i  = 0;
         int j = nums.length -1;
        while ( i < j){
            if(target - aux.get(i).getValue() == aux.get(j).getValue()){
                result[0] = aux.get(i).getIndex();
                result[1] = aux.get(j).getIndex();
                return result;

            } else if (target - aux.get(i).getValue() < aux.get(j).getValue() ) {
                j--;
            }else
                i++;
        }

           return result;
    }
    //O(n)
    public int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i =0; i< nums.length; i++){
            int dif = target - nums[i];
            if(map.containsKey(dif)){
                return new int[]{ map.get(dif), i };
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No solution found");
    }

    class IndexValue{
        int value;
        int index;
        public IndexValue(int index, int value){
            this.index = index;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }
}
