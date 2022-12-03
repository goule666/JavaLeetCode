package com.goule666.leetcode.doublepointer.num70207;


/**
 * @author niewenlong
 * @date 2022/12/3 14:33
 * @description 面试题 02.07. 链表相交
 * @leetCodeUrl <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/">...</a>
 **/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int headSizeA = 0, headSizeB = 0;
        ListNode curA = headA;
        while (curA != null) {
            headSizeA++;
            curA = curA.next;
        }
        ListNode curB = headB;
        while (curB != null) {
            headSizeB++;
            curB = curB.next;
        }
        if (headSizeA >= headSizeB) {
            //A 移动
            int moveSize = headSizeA - headSizeB;
            while (headA != null && moveSize-- > 0) {
                headA = headA.next;
            }
        } else {
            //B 移动
            int moveSize = headSizeB - headSizeA;
            while (headB != null && moveSize-- > 0) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getIntersectionNode(new ListNode(1), new ListNode(2)));
    }
}
