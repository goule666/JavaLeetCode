package com.goule666.leetcode.hashtable.num60454;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niewenlong
 * @date 2022/11/18 16:08
 * @description 第454题.四数相加II
 * @leetCodeUrl <a href="https://leetcode.cn/problems/4sum-ii/">...</a>
 **/
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> abMap = new HashMap<>(16);
        for (int i : nums1) {
            for (int i1 : nums2) {
                int temp = i + i1;
                abMap.put(temp, abMap.getOrDefault(temp, 0) + 1);
            }
        }
        int result = 0;
        for (int i3 : nums3) {
            for (int i4 : nums4) {
                int temp = i3 + i4;
                if (abMap.containsKey((-temp))) {
                    result += abMap.get(-temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
