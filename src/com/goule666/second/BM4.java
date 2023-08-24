package com.goule666.second;

/**
 * @author niewenlong
 * @date 2023/8/24 20:08
 * @description
 **/
public class BM4 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param pHead1 ListNode类
         * @param pHead2 ListNode类
         * @return ListNode类
         */
        public ListNode Merge(ListNode pHead1, ListNode pHead2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (pHead1 != null && pHead2 != null) {
                if (pHead1.val < pHead2.val) {
                    cur.next = pHead1;
                    pHead1 = pHead1.next;
                } else {
                    cur.next = pHead2;
                    pHead2 = pHead2.next;
                }
                cur = cur.next;
            }
            if (pHead1 != null) {
                cur.next = pHead1;
            }
            if (pHead2 != null) {
                cur.next = pHead2;
            }
            return dummy.next;
        }
    }
}
