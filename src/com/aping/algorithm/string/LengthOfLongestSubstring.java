package com.aping.algorithm.string;

import java.util.HashMap;

/**
 * @author Aping·
 * @since 2022/9/25
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = 1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(0), 0);
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
