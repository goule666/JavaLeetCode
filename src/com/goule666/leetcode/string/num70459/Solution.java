package com.goule666.leetcode.string.num70459;

/**
 * @author niewenlong
 * @date 2022/11/29 11:34
 * @description 459.重复的子字符串
 * @leetCodeUrl <a href="https://leetcode.cn/problems/repeated-substring-pattern/">...</a>
 **/
public class Solution {
    /**
     * 暴力解法
     *
     * @param s param
     * @return result
     */
    public boolean repeatedSubstringPattern(String s) {
        //check param
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            String split = s.substring(0, i + 1);
            if (s.length() % split.length() != 0) {
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) != split.charAt(j % (split.length()))) {
                    //loop check
                    break;
                }
                if (j == s.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("aabaab"));
    }
}
