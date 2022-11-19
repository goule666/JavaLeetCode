package com.goule666.leetcode.hashtable.num80015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niewenlong
 * @date 2022/11/19 22:23
 * @description 第15题. 三数之和
 * @leetCodeUrl <a href="https://leetcode.cn/problems/3sum/">...</a>
 **/
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int left = a + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[a] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[a], nums[left], nums[right]));
                    //去重left、right
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                } else if (nums[a] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[a] + nums[left] + nums[right] < 0) {
                    left++;
                }
            }
        }
        return result;
    }
}
