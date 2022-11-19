package com.goule666.leetcode.hashtable.num50001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author niewenlong
 * @date 2022/11/17 09:59
 * @description 1. 两数之和
 * @leetCodeUrl <a href="https://leetcode.cn/problems/two-sum/">...</a>
 **/
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                result[0] = i;
                result[1] = map.get(a);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
