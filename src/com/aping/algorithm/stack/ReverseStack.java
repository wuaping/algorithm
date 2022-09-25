package com.aping.algorithm.stack;

import java.util.Stack;

/**
 * @author Aping
 * @since 2022/9/25
 */
public class ReverseStack {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverseStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = popLast(stack);
        reverseStack(stack);
        stack.push(last);
    }

    public static Integer popLast(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int last = popLast(stack);
        stack.push(result);
        return last;
    }
}
