package com.goule666.leetcode.hashtable.num30349;

import java.util.*;

/**
 * @author niewenlong
 * @date 2022/11/16 19:03
 * @description 349. 两个数组的交集
 * @leetCodeUrl <a href="https://leetcode.cn/problems/intersection-of-two-arrays/">...</a>
 **/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return null;
        }
        Set<Integer> numsSet1 = new HashSet<>();

        for (int i : nums1) {
            numsSet1.add(i);
        }
        Set<Integer> result = new HashSet<>();
        for (int j : nums2) {
            if (numsSet1.contains(j)) {
                result.add(j);
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }

}
