package com.masteringdsa.dsaconcepts.array;

import java.util.*;

public class Array {

    int[] items;
    int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item){
        if(count == items.length){
            var newItems = new int[count * 2];
            for(int i = 0; i < items.length; i++){
                newItems[i] = items[i];
            }
            items = newItems;
        }

        items[count++] = item;
    }

    public void removeAt(int index){
        if(index < 0 || index > count){
            throw new IllegalArgumentException();
        }

        for(int i = index; i < count; i++){
            items[i] = items[i + 1];
        }

        count--;
    }

    public int indexOf(int item){
        for(int i = 0; i < count; i++){
            if(items[i] == item)
                return i;
        }

        return -1;
    }

    public int max(){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < count; i++){
            if(items[i] > max)
                max = items[i];
        }
        return max;
    }

    public int min(){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < count; i++){
            if(items[i] < min)
                min = items[i];
        }
        return min;
    }

    public int[] intersect(int[] array){
//        var intersectArray = new int[10];
//        var index = 0;
//        for(int i = 0; i < count; i++){
//            for(int j = 0; j < array.length; j++){
//                if(items[i] == array[j]){
//                    intersectArray[index++] = items[i];
//                }
//            }
//        }

        var uniqueSet = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();

        for(int item : items){
            uniqueSet.add(item);
        }

        for (int item : array) {
            if (uniqueSet.contains(item)) {
                resultList.add(item);
                uniqueSet.remove(item);
            }
        }

        int[] result = new int[resultList.size()];

        for(int i = 0; i < result.length; i++){
            result[i] = resultList.get(i);
        }

        return result;
    }

    public void reverse(){

        int start = 0;
        int end = count - 1;

        while(start < end){
            int temp = items[start];
            items[start] = items[end];
            items[end] = temp;

            start++;
            end--;
        }
    }

    public void insertAt(int item, int index) {

        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Invalid index");
        }

        if (count == items.length) {
            var newItems = new int[count * 2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        for (int i = count - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }

        items[index] = item;
        count++;
    }

    public void print(){
        System.out.print("[");
        for (int item : items) {
            System.out.print(item + "  ");
        }
        System.out.print("]");
    }

    public int sum(){
        int sum = 0;
        for(int i = 0; i < count; i++){
            sum += items[i];
        }

        return sum;
    }

    public boolean isSorted(){
        for(int i = 0; i < count - 1; i++){
            if(items[i] > items[i + 1])
                return false;
        }

        return true;
    }

    public int length(){
        return count;
    }

    public int secondLargest(){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i < count; i++){
            if(items[i] > largest){
                secondLargest = largest;
                largest = items[i];
            } else if (items[i] > secondLargest && items[i] < largest) {
                secondLargest = items[i];
            }
        }

        return secondLargest;
    }

    public void getFrequencyOfElement(){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < count; i++){
            if(!map.containsKey(items[i])){
                map.put(items[i], 1);
            }else{
                map.put(items[i], map.get(items[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " times");
        }
    }

    public void leftRotate(){
        int firstElement = items[0];

        for(int i = 1; i < items.length; i++){
            items[i - 1] = items[i];
        }

        items[count - 1] = firstElement;
    }

    public void rightRotate(){
        int lastElement = items[count - 1];

        for(int i = count - 2; i >= 0; i--){
            items[i + 1] = items[i];
        }

        items[0] = lastElement;
    }

    public void moveZerosToEnd(){
        /*
        * [0, 1, 0, 3, 12]
        * i = 1, j = 0
        *
        * */
        int j = 0;
        for(int i = 0; i < count; i++){
            if(items[i] != 0){
                items[j] = items[i];

                if(i != j){
                    items[i] = 0;
                }

                j++;
            }
        }
    }

    public void moveOddToEnd(){
        /*
        * [12, 34, 45, 9, 8, 90, 3]
        *
        * */

        int j = 0;
        for(int i = 0; i < count; i++){
            if(items[i] % 2 == 0){

                int temp = items[j];
                items[j] = items[i];
                items[i] = temp;

                j++;
            }
        }
    }

    public int findMissingNumber(){
        int n = count + 1;
        int expectedSum = n * (n + 1)/2;
        int actualSum = 0;

        for(int i = 0; i < count; i++){
            actualSum += items[i];
        }

        return expectedSum - actualSum;
    }
}
