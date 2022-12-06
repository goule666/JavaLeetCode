package com.goule666.leetcode.stackandqueue.num10232;

import java.util.Stack;

/**
 * @author niewenlong
 * @date 2022/12/6 20:04
 * @description 232. 用栈实现队列
 * @leetCodeUrl <a href="https://leetcode.cn/problems/implement-queue-using-stacks/">...</a>
 **/
public class MyQueue {

    private Stack<Integer> inputStack = new Stack<>();

    private Stack<Integer> outputStack = new Stack<>();


    public MyQueue() {

    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        //move inputStack item to outputStack
        while (!inputStack.empty()) {
            outputStack.push(inputStack.pop());
        }
        int result = outputStack.pop();
        //move outputStack item to inputStack
        while (!outputStack.empty()) {
            inputStack.push(outputStack.pop());
        }
        return result;
    }


    public int peek() {
        //move inputStack item to outputStack
        while (!inputStack.empty()) {
            outputStack.push(inputStack.pop());
        }
        int result = outputStack.peek();
        //move outputStack item to inputStack
        while (!outputStack.empty()) {
            inputStack.push(outputStack.pop());
        }
        return result;
    }

    public boolean empty() {
        return inputStack.empty() && outputStack.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
