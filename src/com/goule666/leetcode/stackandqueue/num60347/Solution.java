package com.goule666.leetcode.stackandqueue.num60347;


import java.util.*;

/**
 * @author niewenlong
 * @date 2022/12/7 19:17
 * @description 347. 前 K 个高频元素
 * @leetCodeUrl <a href="https://leetcode.cn/problems/top-k-frequent-elements/">...</a>
 **/
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (ints1, ints2) -> ints2[1] - ints1[1]);
        map.forEach((key, value) -> {
            priorityQueue.add(new int[]{key, value});
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}