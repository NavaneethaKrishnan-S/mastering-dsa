package com.masteringdsa.dsaconcepts.queue;

import java.util.Stack;

public class QueueWithTwoStacks {

    private Stack<Integer> insertionStack = new Stack<>();
    private Stack<Integer> deletionStack = new Stack<>();
    private Stack<Integer> stackForReverse = new Stack<>();

    public void enqueue(int item){
        insertionStack.push(item);
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        moveInsertionToDeletionStack();

        var item = deletionStack.pop();
        return item;
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        moveInsertionToDeletionStack();

        var item = deletionStack.peek();
        return item;
    }

    private void moveInsertionToDeletionStack() {
        if(deletionStack.isEmpty()){
            while(!insertionStack.isEmpty()){
                deletionStack.push(insertionStack.pop());
            }
        }
    }

    public boolean isEmpty(){
        return insertionStack.isEmpty() && deletionStack.isEmpty();
    }

    @Override
    public String toString() {
        while(!deletionStack.isEmpty()){
            stackForReverse.push(deletionStack.pop());
        }

        return stackForReverse.toString();
    }
}
