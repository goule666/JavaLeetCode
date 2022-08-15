package num0024;

/**
 * @author niewenlong
 * @date 2022/8/9 19:59
 * @description 24. 两两交换链表中的节点
 * @leetCodeUrl <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">...</a>
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prevNode = dummyNode;
        while (head != null && head.next != null) {
            ListNode temp = head.next.next;
            //指针修改指向
            prevNode.next = head.next;
            head.next.next = head;
            head.next = temp;

            //移位
            prevNode = head;
            head = head.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }
}
