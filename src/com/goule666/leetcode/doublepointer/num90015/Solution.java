package com.goule666.leetcode.doublepointer.num90015;


import java.util.*;

/**
 * @author niewenlong
 * @date 2022/12/3 14:33
 * @description 第15题. 三数之和
 * @leetCodeUrl <a href="https://leetcode.cn/problems/3sum/">...</a>
 **/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        //sort
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                continue;
            }
            //distinct
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                if (nums[leftIndex] + nums[rightIndex] + nums[i] > 0) {
                    rightIndex--;
                } else if (nums[leftIndex] + nums[rightIndex] + nums[i] < 0) {
                    leftIndex++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }
                    leftIndex++;
                    rightIndex--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
