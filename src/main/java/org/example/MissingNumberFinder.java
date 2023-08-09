package org.example;
//Дан массив размера  n-1, содержащий только различные целые числа в диапазоне от 1 до n . Найдите недостающий элемент.
//
//
//input:
//arr[] = {1,2,3,5}
//out: 4
//
//
//arr[] = {6,1,2,8,3,4,7,10,5}
//out: 9
public class MissingNumberFinder {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5};
        System.out.println("Missing element in arr1: " + findMissingNumber(arr1));

        int[] arr2 = {6, 1, 2, 8, 3, 4, 7, 10, 5};
        System.out.println("Missing element in arr2: " + findMissingNumber(arr2));
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = (n * (n + 1)) / 2;

        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}

