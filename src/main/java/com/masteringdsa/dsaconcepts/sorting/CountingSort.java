package com.masteringdsa.dsaconcepts.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {};
        sort(arr, 7);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int max){
        int[] count = new int[max + 1];

        for (int item : arr) {
            count[item]++;
        }

        int j = 0;
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0){
                while(count[i] != 0){
                    arr[j++] = i;
                    count[i]--;
                }
            }
        }
    }
}
