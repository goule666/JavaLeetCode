package com.goule666.leetcode.linkedList.num20142;

import com.goule666.leetcode.ListNode;


/**
 * @author niewenlong
 * @date 2022/9/5 15:28
 * @description 142. 环形链表 II
 * @leetCodeUrl <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">...</a>
 **/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //第一步 判断是否有环
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //有环
                //第二步 分别从起点走x步、从相遇点走z步 当相等的时候 就是环的入口
                ListNode xNode = head;
                while (slow != null && slow.next != null) {
                    if (slow == xNode) {
                        return slow;
                    }
                    slow = slow.next;
                    xNode = xNode.next;
                }
                return null;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
