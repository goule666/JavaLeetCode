package com.goule666.leetcode.linkedList.num10207;


import com.goule666.leetcode.linkedList.ListNode;

/**
 * @author niewenlong
 * @date 2022/8/30 12:34
 * @description 面试题 02.07. 链表相交
 * @leetCodeUrl <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/submissions/">...</a>
 **/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        long lengthA = 0L;
        long lengthB = 0L;
        ListNode tempSizeA = headA;
        ListNode tempSizeB = headB;
        while (tempSizeA != null) {
            lengthA++;
            tempSizeA = tempSizeA.next;
        }

        while (tempSizeB != null) {
            lengthB++;
            tempSizeB = tempSizeB.next;
        }
        tempSizeA = headA;
        tempSizeB = headB;

        if (lengthA < lengthB) {
            long temp = lengthA;
            lengthA = lengthB;
            lengthB = temp;

            ListNode tempNode = tempSizeA;
            tempSizeA = tempSizeB;
            tempSizeB = tempNode;

        }
        long moveSize = lengthA - lengthB;
        while (moveSize-- > 0 && tempSizeA != null) {
            tempSizeA = tempSizeA.next;
        }
        while (lengthB-- > 0 && tempSizeA != null && tempSizeB != null) {
            if (tempSizeA == tempSizeB) {
                return tempSizeA;
            }
            tempSizeA = tempSizeA.next;
            tempSizeB = tempSizeB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(8);
        ListNode intersectionNode = solution.getIntersectionNode(new ListNode(4, new ListNode(1, listNode)), new ListNode(5, new ListNode(0, listNode)));
        System.out.println(intersectionNode);
    }
}
