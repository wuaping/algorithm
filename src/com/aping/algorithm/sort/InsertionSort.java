package com.aping.algorithm.sort;

/**
 * 插入排序
 *
 * @author Aping
 * @since 2022/9/5
 */
public class InsertionSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = 1; end < arr.length; end++) {
            for (int cur = end; cur - 1 >= 0 && arr[cur - 1] > arr[cur]; cur--) {
                swap(arr, cur - 1, cur);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void pintArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {22, 99, 1, 23, 4, 5, 1, 16, 55};
        pintArray(arr);
        sort(arr);
        pintArray(arr);
    }
}
