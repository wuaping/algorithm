package com.aping.algorithm.array;

import java.util.HashMap;

/**
 * 和为 k 的子数组
 *
 * @author Aping
 * @since 2022/9/26 11:10
 */
public class SubarraySum {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
