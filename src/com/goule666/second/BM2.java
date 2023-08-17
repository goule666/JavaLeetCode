package com.goule666.second;

/**
 * @author niewenlong
 * @date 2023/8/16 20:25
 * @description
 **/
public class BM2 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param head ListNode类
         * @param m    int整型
         * @param n    int整型
         * @return ListNode类
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            // write code here
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = head;
            for (int i = 1; i < m; i++) {
                cur = cur.next;
                pre = pre.next;
            }
            for (int j = 0; j < (n - m); j++) {
                ListNode next = cur.next;
                ListNode nextNext = next.next;
                next.next = pre.next;
                pre.next = next;
                cur.next = nextNext;
            }

            return dummy.next;
        }
    }

}
