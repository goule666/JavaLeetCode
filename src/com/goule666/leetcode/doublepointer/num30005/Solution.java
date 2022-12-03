package com.goule666.leetcode.doublepointer.num30005;

import java.util.Arrays;

/**
 * @author niewenlong
 * @date 2022/12/3 14:33
 * @description 题目：剑指Offer 05.替换空格
 * @leetCodeUrl <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">...</a>
 **/
public class Solution {
    public String replaceSpace(String s) {
        //check
        if (s == null || s.length() == 0) {
            return "";
        }

        //expansion
        int needExpansionSize = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                needExpansionSize += 2;
            }
        }
        char[] resizeChar = Arrays.copyOf(s.toCharArray(), s.length() + needExpansionSize);

        //move
        int leftIndex = s.length() - 1;
        int rightIndex = resizeChar.length - 1;
        for (int i = leftIndex; i >= 0; i--) {
            if (resizeChar[i] != ' ') {
                resizeChar[rightIndex--] = resizeChar[i];
            } else {
                resizeChar[rightIndex--] = '0';
                resizeChar[rightIndex--] = '2';
                resizeChar[rightIndex--] = '%';
            }
        }
        return new String(resizeChar);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }
}
