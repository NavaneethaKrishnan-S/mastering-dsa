package org.eminds.dsaconcepts.array;

public class Main {
    public static void main(String[] args){
        //var newArray = new int[]{10, 20, 30, 60};

        var array = new Array(5);

        array.insert(7);
        array.insert(5);
        array.insert(2);
        array.insert(4);
        array.insert(3);
        array.insert(1);

        System.out.println(array.findMissingNumber());

        array.print();
    }
}
