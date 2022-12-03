package com.goule666.leetcode.linkedList;

/**
 * @author niewenlong
 * @date 2022/8/18 12:29
 * @description
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}