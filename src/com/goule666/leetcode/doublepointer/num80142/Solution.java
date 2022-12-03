package com.goule666.leetcode.doublepointer.num80142;


/**
 * @author niewenlong
 * @date 2022/12/3 14:33
 * @description 142. 环形链表 II
 * @leetCodeUrl <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">...</a>
 **/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        //find cycle
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                //meeting
                while (head != null && slow != null) {
                    if (head == slow) {
                        return slow;
                    }
                    head = head.next;
                    slow = slow.next;
                }
                return null;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCycle(new ListNode(1)));
    }
}
