package com.goule666.leetcode.doublepointer.num60019;


/**
 * @author niewenlong
 * @date 2022/12/3 14:33
 * @description 19. 删除链表的倒数第 N 个结点
 * @leetCodeUrl <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">...</a>
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            if (fast.next == null) {
                slow.next = slow.next.next;
                break;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeNthFromEnd(new ListNode(1), 1));
    }
}
