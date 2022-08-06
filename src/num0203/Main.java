package num0203;


/**
 * @author niewenlong
 * @date 2022/8/6 16:07
 * @description
 **/
public class Main {
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode virtual = new ListNode(0, head);
        ListNode prev = virtual;
        ListNode pointer = virtual;
        do {
            if (pointer.val == val) {
                prev.next = pointer.next;
            } else {
                prev = pointer;
            }
        } while ((pointer = pointer.next) != null);
        return virtual.next;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.removeElements(new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3)))), 6);
    }
}
