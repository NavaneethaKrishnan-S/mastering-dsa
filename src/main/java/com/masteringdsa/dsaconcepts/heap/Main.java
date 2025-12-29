package com.masteringdsa.dsaconcepts.heap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 1, 8, 10, 24, 12};
        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void heapSort(int[] numbers) {
        var heap = new Heap(10);
        for(var number : numbers)
            heap.insert(number);
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = heap.remove();
        }
        System.out.println(Arrays.toString(numbers));
    }
}
