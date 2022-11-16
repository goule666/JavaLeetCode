package com.goule666.leetcode.hashtable.num21002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niewenlong
 * @date 2022/11/14 19:23
 * @description 1002. 查找常用字符
 * @leetCodeUrl <a href="https://leetcode.cn/problems/find-common-characters/">...</a>
 **/
public class Solution {
    public List<String> commonChars(String[] words) {
        //check param
        if (words == null || words.length == 0) {
            return new ArrayList<>(10);
        }
        if (words.length == 1) {
            return Arrays.asList(words);
        }
        int[] hashOri = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            hashOri[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] tempHash = new int[26];
            for (int i1 = 0; i1 < words[i].length(); i1++) {
                tempHash[words[i].charAt(i1) - 'a']++;
            }
            for (int i1 = 0; i1 < hashOri.length; i1++) {
                hashOri[i1] = Math.min(hashOri[i1], tempHash[i1]);
            }
        }
        List<String> result = new ArrayList<>(10);
        for (int i = 0; i < hashOri.length; i++) {
            while (hashOri[i]-- > 0) {
                result.add(String.valueOf((char)('a' + (char) i)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.commonChars(new String[]{"bella", "label", "roller"});
    }
}
