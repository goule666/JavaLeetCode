package com.goule666.second;

/**
 * @author niewenlong
 * @date 2023/8/21 20:14
 * @description
 **/
public class BM3 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        /**
         *
         * @param head ListNode类
         * @param k int整型
         * @return ListNode类
         */
        public ListNode reverseKGroup (ListNode head, int k) {
            ListNode tail = head;
            for (int i=0; i<k; i++) {
                if (tail == null) {
                    return head;
                }
                tail = tail.next;
            }
            ListNode pre = null;
            ListNode cur = head;
            while (cur != tail) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            head.next = reverseKGroup(tail,k);
            return pre;
        }
    }
}
