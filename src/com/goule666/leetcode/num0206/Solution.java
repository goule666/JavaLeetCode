package com.goule666.leetcode.num0206;

/**
 * @author niewenlong
 * @date 2022/8/8 12:40
 * @description 206. 反转链表
 * @leetCodeUrl <a href="https://leetcode.cn/problems/reverse-linked-list/">...</a>
 **/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseList(new ListNode(1));
    }

}
