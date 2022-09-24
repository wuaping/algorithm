package com.aping.algorithm.sort;

/**
 * 冒泡排序：相邻比较，大的往右移
 *
 * @author Aping
 * @since 2022/9/5
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = arr.length - 1; end >= 0; end--) {
            for (int i = 0; i <= end - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
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
