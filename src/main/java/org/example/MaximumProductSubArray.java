package org.example;
/**
 *
 * Given an integer array nums, find a
 * subarray
 *  that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *  */
public class MaximumProductSubArray {
    public static void main(String []args ){
        int nums [] = {-2,-3,-2,-4};
        int nums1 [] = {2,3,-2,4};
        System.out.println(new MaximumProductSubArray().maxProduct(nums1));
    }



    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        // Inicializamos las variables con el primer número
        int maxProductSoFar = nums[0];
        int minProductSoFar = nums[0];
        int result = nums[0];  // Resultado final

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // Si el número es negativo, intercambiamos max y min
            if (num < 0) {
                int temp = maxProductSoFar;
                maxProductSoFar = minProductSoFar;
                minProductSoFar = temp;
            }

            maxProductSoFar = Math.max(num, maxProductSoFar * num);
            minProductSoFar = Math.min(num, minProductSoFar * num);


            result = Math.max(result, maxProductSoFar);
        }

        return result;

    }
}
