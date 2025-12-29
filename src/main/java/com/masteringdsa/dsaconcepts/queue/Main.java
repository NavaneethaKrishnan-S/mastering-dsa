package com.masteringdsa.dsaconcepts.queue;

import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        PriorityQueue queue = new PriorityQueue(6);
        queue.enqueue(10);
        queue.enqueue(40);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(50);
        queue.enqueue(5);

        System.out.println(queue);

    }

    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty())
            stack.push(queue.remove());

        while(!stack.isEmpty())
            queue.add(stack.pop());
    }
}
