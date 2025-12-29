package com.masteringdsa.dsaconcepts.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // [8, 2, 4, 1, 3]
    // i
    public static void mergeSort(int[] arr){
        if(arr.length < 2)
            return;

        int middle = arr.length / 2;

        int[] left = new int[middle];
        for(int i = 0; i < middle; i++){
            left[i] = arr[i];
        }

        int[] right = new int[arr.length - middle];
        for(int i = middle; i < arr.length; i++){
            right[i - middle] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                result[k++] = left[i++];
            }else{
                result[k++] = right[j++];
            }
        }

        while(i < left.length)
            result[k++] = left[i++];

        while(j < right.length)
            result[k++] = right[j++];
    }
}
