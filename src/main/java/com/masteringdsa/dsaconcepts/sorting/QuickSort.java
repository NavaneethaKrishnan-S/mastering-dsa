package com.masteringdsa.dsaconcepts.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {15, 6, 3, 1, 22, 10, 13};
        sort(arr);
        System.out.println(Arrays.toString(arr));;
    }

    // [8, 2, 4, 1, 3]
    //              p
    public static void sort(int[] arr){
        int pivot = arr.length - 1;
        int boundary = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= arr[pivot]){
                boundary++;
                swap(boundary, i, arr);
            }

            if(boundary == pivot){
                return;
            }
        }

        int[] left = new int[pivot - 1];
        for(int i = 0; i < left.length; i++){
            left[i] = arr[i];
        }

        int[] right = new int[arr.length - pivot];


    }

    private static void swap(int boundary, int i, int[] arr) {
        int temp = arr[boundary];
        arr[boundary] = arr[i];
        arr[i] = temp;
    }
}
