package com.goule666.leetcode.hashtable.num40202;

import java.util.HashSet;
import java.util.Set;

/**
 * @author niewenlong
 * @date 2022/11/16 20:02
 * @description 第202题. 快乐数
 * @leetCodeUrl <a href="https://leetcode.cn/problems/happy-number/">...</a>
 **/
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> records = new HashSet<>();
        while (n != 1 && !records.contains(n)) {
            records.add(n);
            n = getSum(n);
        }

        return n == 1;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
