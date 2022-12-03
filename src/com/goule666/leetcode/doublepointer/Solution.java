package com.goule666.leetcode.doublepointer;

/**
 * @author niewenlong
 * @date 2022/12/3 13:50
 * @description 27. 移除元素
 * @leetCodeUrl <a href="https://leetcode.cn/problems/remove-element/">...</a>
 **/
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slowPointer = 0;
        for (int fastPointer = 0; fastPointer < nums.length; fastPointer++) {
            if (nums[fastPointer] == val) {
                continue;
            }
            nums[slowPointer++] = nums[fastPointer];
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{3, 1, 2, 3, 3}, 3));
    }
}
