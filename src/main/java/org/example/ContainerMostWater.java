package org.example;
/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 * */
public class ContainerMostWater {

    public static void main(String [] args){
        int [] heigth  = {1,8,6,2,5,4,8,3,7};
        int [] heigth1  = {1,1};
        System.out.println(new ContainerMostWater().maxArea(heigth));
    }

    public int maxArea(int[] height) {
        int result = 0;
        int max =0;
        int i =0;
        int j = height.length-1;
        while (i< j){
           int minValue = Math.min(height[i],height[j]);
            max = minValue * (j-i);
            if(max > result ){
                result = max;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }


        }


     return result;
    }
}
