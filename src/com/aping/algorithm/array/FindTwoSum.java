package com.aping.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * @author Aping
 * @since 2022/9/3
 */
public class FindTwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15, 18, 1, 6};

        int[] result = findTwoSum(arr, 17);
        System.out.println(Arrays.toString(result));

    }

    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length - 1);
        hashMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int another = target - nums[i];
            if (hashMap.get(another) != null) {
                return new int[]{i, hashMap.get(another)};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

}
