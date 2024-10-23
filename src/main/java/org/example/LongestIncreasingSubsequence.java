package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 *
 * */
public class LongestIncreasingSubsequence {
    public static void main(String [] args){
        int [] nums = {10,9,2,5,3,7,101,18};
        int [] nums1 = {0,1,0,3,2};
        int [] nums2 = {0,1,2,3,4,5,6,7};

        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums1));
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i =0; i< nums.length; i++){
             if(result.isEmpty() || result.get(result.size() - 1) < nums[i]){
                 result.add(nums[i]);
             }
             else{
                 result.set(binarySearch(result, nums[i]), nums[i]);
             }
        }
        return result.size();
    }
    public int binarySearch (List<Integer> nums, int num){
        int left = 0;
        int rigth  =nums.size() -1;

        while(left <= rigth){
            int mid = (rigth + left)/2;
            if(num == nums.get(mid)) return mid;
            if(nums.get(mid)> num)  rigth = mid-1;
            else left = mid+1;
        }
        return left;
    }
}
