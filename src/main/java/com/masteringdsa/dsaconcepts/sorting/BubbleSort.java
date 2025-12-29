package com.masteringdsa.dsaconcepts.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {12, 2, 5, 1, 90, 12, 3, 4};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        boolean isSorted;

        for(int i = 0; i < arr.length; i++){
            isSorted = true;
            for(int j = 1; j < arr.length; j++){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                    isSorted = false;
                }
            }

            if(isSorted)
                return;
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
