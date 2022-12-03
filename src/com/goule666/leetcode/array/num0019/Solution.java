package com.goule666.leetcode.array.num0019;

/**
 * @author niewenlong
 * @date 2022/8/18 12:29
 * @description 19. 删除链表的倒数第 N 个结点
 * @leetCodeUrl <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">...</a>
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeNthFromEnd(new ListNode(1, new ListNode(2)), 1);

    }
}
