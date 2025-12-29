package com.masteringdsa.dsaconcepts.stack;

import java.util.Arrays;

public class Stack {
    private int[] items;
    private int count;

    public Stack(int length) {
        items = new int[length];
    }

    public void push(int item){
        if(count == items.length)
            throw new StackOverflowError();

        items[count++] = item;
    }

    public int pop(){
        if(isEmpty())
            throw new IllegalArgumentException();

        return items[--count];
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        return items[count - 1];
    }

    public boolean isEmpty(){
        return count == 0;
    }


    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
