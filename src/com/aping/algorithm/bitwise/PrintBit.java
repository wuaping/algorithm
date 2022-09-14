package com.aping.algorithm.bitwise;

/**
 * @author Aping
 * @since 2022/9/5
 */
public class PrintBit {

    public static void main(String[] args) {
        print(4);
        print(-100000);
        print(-100000 >> 3);
        print(-100000 >>> 3);
    }

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            // 每个位和1相与，结果为0,原位置为0，否则原位置为1
            System.out.print((num & (1 << i)) == 0 ? "0" : 1);
        }
        System.out.println();
    }
}
