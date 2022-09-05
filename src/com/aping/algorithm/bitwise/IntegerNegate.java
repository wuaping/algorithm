package com.aping.algorithm.bitwise;

/**
 * @author Aping
 * @since 2022/9/5
 */
public class IntegerNegate {

    public static void main(String[] args) {
        int n = 5;
        // 打印n的相反数
        System.out.println(-n);
        // 位取反后+1就是相反数
        System.out.println(~n + 1);
        System.out.println("-------------------");

        int max = Integer.MAX_VALUE;
        System.out.println(max);
        System.out.println(~max + 1);
        System.out.println("-------------------");

        int min = Integer.MIN_VALUE;
        System.out.println(min);
        System.out.println((~min + 1));
        System.out.println("-------------------");

        int zero = 0;
        System.out.println(zero);
        System.out.println((~zero + 1));
    }
}
