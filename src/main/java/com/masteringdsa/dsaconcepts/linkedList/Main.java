package com.masteringdsa.dsaconcepts.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

//        var array = list.toArray();
//
////        System.out.println(Arrays.toString(array));
////        System.out.println(list.getKthFromTheEnd(0));
//
        System.out.println(list.getMiddleElement());

//        list.insertAtMiddle(35);
    }
}
