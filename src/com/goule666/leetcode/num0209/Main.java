package com.goule666.leetcode.num0209;


/**
 * @author niewenlong
 * @description 209. 长度最小的子数组
 * @leetCodeUrl <a href="https://leetcode.cn/problems/minimum-size-subarray-sum">...</a>
 */
public class Main {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int result = 0;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                if (result == 0) {
                    result = right - left + 1;
                } else {
                    result = Math.min(result, right - left + 1);
                }
                sum = sum - nums[left++];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}