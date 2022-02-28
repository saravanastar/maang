package com.ask.log.ds.stack;

import java.util.Stack;

class QueueWithStack {

    public static void main(String[] args) {
        QueueWithStack queueWithStack = new QueueWithStack();
        queueWithStack.push(5);
        queueWithStack.push(6);
        queueWithStack.push(7);

        System.out.println(queueWithStack.peek());
        System.out.println(queueWithStack.pop());
        System.out.println(queueWithStack.peek());
        System.out.println(queueWithStack.pop());
        System.out.println(queueWithStack.empty());
        System.out.println(queueWithStack.pop());
        System.out.println(queueWithStack.empty());
    }
    private final Stack<Integer> queue;

    public QueueWithStack() {
        queue = new Stack<>();

    }

    public void push(int x) {

        if (queue.isEmpty()) {
            queue.push(x);
        } else {
            Stack<Integer> temp = new Stack<>();
            while (!queue.isEmpty()) {
                temp.push(queue.pop());
            }
            queue.push(x);
            while (!temp.isEmpty()) {
                queue.push(temp.pop());
            }
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
