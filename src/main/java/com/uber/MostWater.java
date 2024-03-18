package com.uber;

/**
 * 11. Container With Most Water (Medium)
 * https://leetcode.com/problems/container-with-most-water/description/
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
public class MostWater { // This solution has a time complexity of O(n),
    // where n is the number of elements in the height array,
    // as we only need to traverse the array once with the two-pointer approach.
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length -1;

        int maxArea = 0;
        while( left < right ) {
            int currentArea =  Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if( height[left] < height[right] )
                left++;
            else
                right--;
        }

        return maxArea;

    }


}
