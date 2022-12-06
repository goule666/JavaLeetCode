package com.goule666.leetcode.stackandqueue.num20225;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author niewenlong
 * @date 2022/12/6 20:23
 * @description 225. 用队列实现栈
 * @leetCodeUrl <a href="https://leetcode.cn/problems/implement-stack-using-queues/">...</a>
 **/
public class MyStack {
    private Deque<Integer> deque = new LinkedBlockingDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        deque.addLast(x);
    }

    public int pop() {
        return deque.pollLast();
    }

    public int top() {
        return deque.peekLast();
    }

    public boolean empty() {
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
