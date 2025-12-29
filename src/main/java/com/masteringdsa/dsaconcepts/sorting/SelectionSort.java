package com.masteringdsa.dsaconcepts.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {30, 12, 5, 2, 8, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            var minIndex = findMinValue(arr, i);
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int index, int minIndex) {
        int temp = arr[index];
        arr[index] = arr[minIndex];
        arr[minIndex] = temp;

    }

    private static int findMinValue(int[] nums, int index) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = index; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
