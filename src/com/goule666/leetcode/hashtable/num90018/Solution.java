package com.goule666.leetcode.hashtable.num90018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niewenlong
 * @date 2022/11/20 17:26
 * @description 第18题. 四数之和
 * @leetCodeUrl <a href="https://leetcode.cn/problems/4sum/">...</a>
 **/
public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(10);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int second = nums[j];
                int leftIndex = j + 1;
                int rightIndex = nums.length - 1;
                while (leftIndex < rightIndex) {
                    if (first + second + nums[leftIndex] + nums[rightIndex] == target) {
                        result.add(Arrays.asList(first, second, nums[leftIndex], nums[rightIndex]));
                        //去重left、right
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                            leftIndex++;
                        }
                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                            rightIndex--;
                        }
                        leftIndex++;
                    } else if (first + second + nums[leftIndex] + nums[rightIndex] < target) {
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}
