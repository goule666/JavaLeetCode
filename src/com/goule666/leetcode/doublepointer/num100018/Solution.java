package com.goule666.leetcode.doublepointer.num100018;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niewenlong
 * @date 2022/12/3 14:33
 * @description 第18题. 四数之和
 * @leetCodeUrl <a href="https://leetcode.cn/problems/4sum/">...</a>
 **/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        //sort
        Arrays.sort(nums);

        //double loop
        long targetLong = target;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int leftIndex = j + 1;
                int rightIndex = nums.length - 1;
                while (leftIndex < rightIndex) {
                    if ((nums[i] + nums[j] + nums[leftIndex] + nums[rightIndex]) > targetLong) {
                        rightIndex--;
                    } else if (nums[i] + nums[j] + nums[leftIndex] + nums[rightIndex] < targetLong) {
                        leftIndex++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[leftIndex], nums[rightIndex]));
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
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}
