package com.goule666.leetcode.num0707;

/**
 * @author niewenlong
 * @date 2022/8/7 15:22
 * @description 707. 设计链表
 * @leetCodeUrl <a href="https://leetcode.cn/problems/design-linked-list/">...</a>
 **/
public class MyLinkedList {

    public Node head;

    public Node tail;

    public int size = 0;

    class Node {
        public int val;

        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        size++;
        if (head == null) {
            head = tail = new Node(val, null);
            return;
        }
        head = new Node(val, head);
    }

    public void addAtTail(int val) {
        size++;
        if (tail == null) {
            tail = head = new Node(val, null);
            return;
        }
        tail = tail.next = new Node(val, null);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        Node cur = head;
        for (int i = 1; i < index; i++) {
            cur = cur.next;
        }
        cur.next = new Node(val, cur.next);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node dummy = new Node(-1, head);
        Node cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        //头节点设置
        head = dummy.next;
        //尾结点设置
        if (cur.next == null) {
            tail = cur;
        }
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        linkedList.get(1);
        linkedList.deleteAtIndex(1);
        linkedList.get(1);

    }

}
