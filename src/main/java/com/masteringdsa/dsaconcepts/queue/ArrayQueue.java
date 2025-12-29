package com.masteringdsa.dsaconcepts.queue;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int length) {
        items = new int[length];
    }

    public void enqueue(int item){
        if(isFull())
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue(){

        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        return items[front];
    }

    public boolean isEmpty(){
        return rear == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    public int getRear(){
        return items[rear - 1];
    }


    @Override
    public String toString() {
//        var content = Arrays.copyOfRange(items, front, rear);
        return Arrays.toString(items);
    }
}
