package com.masteringdsa.dsaconcepts.linkedList;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    private int length;

    public void addLast(int item){
        var newNode = new Node(item);

        if(isEmpty())
            first = last = newNode;
        else{
            last.next = newNode;
            last = newNode;
        }

        length++;
    }

    public void addFirst(int item){
        var newNode = new Node(item);

        if(isEmpty()){
            first = last = newNode;
        }else{
            newNode.next = first;
            first = newNode;
        }

        length++;
    }

    public int indexOf(int target){
        var currentNode = first;
        int index = 0;

        while(currentNode != null){
            if(currentNode.value == target){
                return index;
            }

            currentNode = currentNode.next;
            index++;
        }

        return -1;
    }

    public boolean isContains(int target){
        return indexOf(target) != -1;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last){
            first = last = null;
        }else{
            var second = first.next;
            first.next = null;
            first = second;
        }

        length--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last){
            first = last = null;
        }else{
            var previousNode = getPrevious(last);
            previousNode.next = null;
            last = previousNode;
        }

        length--;
    }

    private Node getPrevious(Node node){
        var currentNode = first;
        while(currentNode.next != node){
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public int size(){
        return length;
    }

    public int[] toArray(){
        var array = new int[length];
        int index = 0;
        var currentNode = first;
        while(currentNode != null){
            array[index++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

//    public void reverse(){
//        if(isEmpty()){
//            throw new NoSuchElementException();
//        }
//
//        var currentNode = last;
//        while(currentNode != first){
//
//            var previousNode = getPrevious(currentNode);
//            previousNode.next = null;
//            currentNode.next = previousNode;
//            currentNode = previousNode;
//        }
//
//        currentNode.next = null;
//        first = last;
//        last = currentNode;
//    }

    public void reverse(){
        if(isEmpty()) return;

        var previousNode = first;
        var currentNode = first.next;
        while(currentNode != null){
            var nextNode = currentNode.next;
            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = nextNode;
        }

        last = first;
        last.next = null;
        first = previousNode;
    }

    public int getKthFromTheEnd(int k){
        if(k > length)
            throw new IllegalArgumentException();

        var firstPointer = first;
        var secondPointer = first;
        var index = 0;

        while(index < k){
            secondPointer = secondPointer.next;
            index++;
        }

        while(secondPointer != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return firstPointer.value;
    }

    public int getMiddleElement(){
        return getMiddleElement(first);
    }

    private int getMiddleElement(Node first){
        var fast = first;
        var slow = first;

        while(fast !=  null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.value;
    }

    public void insertAtMiddle(int value){
        insertAtMiddle(first, value);
    }

    private void insertAtMiddle(Node root, int value){
        var fast = root;
        var slow = root;

        while(fast !=  null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null && slow != null){
            System.out.println(slow.value);
            System.out.println(fast.value);
        }
    }

}
