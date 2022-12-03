package com.goule666.leetcode.doublepointer.num50206;


/**
 * @author niewenlong
 * @date 2022/12/3 14:33
 * @description 206.反转链表
 * @leetCodeUrl <a href="https://leetcode.cn/problems/reverse-linked-list/">...</a>
 **/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nowNode = null;
        do {
            ListNode next = head.next;
            head.next = nowNode;
            nowNode = head;
            head = next;
        } while (head != null);
        return nowNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseList(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)))))));
    }
}
