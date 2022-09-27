package com.aping.algorithm.array;

import java.util.Arrays;

/**
 * 数组A给定一些1~9的数。返回由A数组中的元素组成的小于n的最大数，例如A={1, 2, 4, 9}，n=2533，返回2499
 *
 * @author Aping
 * @since 2022/9/26 16:33
 */
public class AssembleMin {

    public static void main(String[] args) {
        System.out.println(assembleMin(new int[]{1, 2, 4, 9}, 2533));
        //System.out.println(findLessOrEq(new int[]{1, 2, 4, 9}, 2));
    }

    public static int assembleMin(int[] arr, int min) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Arrays.sort(arr);

        char[] nArr = String.valueOf(min).toCharArray();
        int lessIndex = -1;
        for (int i = nArr.length - 1; i > 0; i--) {
            if (nArr[i] - '0' > arr[0]) {
                lessIndex = i;
                break;
            }
        }

        if (lessIndex == -1) {
            return 0;
        }

        int result = 0;
        int cur;
        boolean less = false;
        for (int i = 0; i <= nArr.length - 1; i++) {
            if (lessIndex == i + 1){
                cur = less ? arr[arr.length - 1] : findLessOrEq(arr, nArr[i] - '0' - 1);
            }else {
                cur = less ? arr[arr.length - 1] : findLessOrEq(arr, nArr[i] - '0');
            }
            if (!less && cur < nArr[i] - '0') {
                less = true;
            }
            result = result * 10 + cur;
        }
        return result;
    }


    public static int findLessOrEq(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= n) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[res];
    }

}
