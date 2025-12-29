package com.masteringdsa.dsaconcepts.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8, 1, 2, 5, 3, 9, 4};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //  0  1  2  3  4
    // [8, 1, 2, 5, 3]
    //     i
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            var current = arr[i];

            int j = i - 1;
            while(j >= 0 && arr[j] > current){
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
    }

}
