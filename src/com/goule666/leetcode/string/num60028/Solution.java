package com.goule666.leetcode.string.num60028;

/**
 * @author niewenlong
 * @date 2022/11/29 11:34
 * @description 28. 找出字符串中第一个匹配项的下标
 * @leetCodeUrl <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/">...</a>
 **/
public class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        genNext(next, needle);
        int cur = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (cur > 0 && haystack.charAt(i) != needle.charAt(cur)) {
                cur = next[cur - 1];
            }
            if (haystack.charAt(i) == needle.charAt(cur)) {
                cur++;
            }
            if (cur == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    /**
     * 理解：
     * 这里核心判断逻辑是拿当前循环的值和当前最大next紧跟着的后面的值做对比，如果相等，则说明继续集成对称属性，如果不相等，则向前寻找，直到寻找到第一个节点
     *
     * @param next 数组
     * @param s    值
     */
    public void genNext(int[] next, String s) {
        int curNext = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (curNext > 0 && s.charAt(i) != s.charAt(curNext)) {
                curNext = next[curNext - 1];
            }
            if (s.charAt(i) == s.charAt(curNext)) {
                curNext++;
            }
            next[i] = curNext;
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aabaabaafa", "aabaaf"));
    }
}
