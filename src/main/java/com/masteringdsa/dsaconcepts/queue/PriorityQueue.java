package com.masteringdsa.dsaconcepts.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item){

        if(isFull())
            throw new IllegalStateException("Queue is full");

        var currentPosition = shiftItemsToInsert(item);
        items[currentPosition] = item;
        count++;
    }

    private boolean isFull() {
        return count == items.length;
    }

    public int shiftItemsToInsert(int item){
        int currentPosition = 0;
        int lastIndex = count - 1;

        for(int i = lastIndex; i >= 0; i--){
            if(items[i] > item)
                items[i + 1] = items[i];
            else{
                currentPosition = i + 1;
                break;
            }
        }
        return currentPosition;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
