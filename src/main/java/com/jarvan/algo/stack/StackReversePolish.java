package com.jarvan.algo.stack;

import java.util.Stack;

/**
 * 逆波兰表达式计算
 */
public class StackReversePolish {
    public static void main(String[] args) {
        int result = reversePolishNotation("363-2*+");
        System.out.println("计算出来的结果：" + result);

    }

    public static int reversePolishNotation(String expression) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        char token;
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            token = expression.charAt(i);
            if (!isOperation(token)) {
                stack.push(Character.getNumericValue(token));
            } else {
                b = stack.pop();
                a = stack.pop();
                switch (token) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.peek();
    }

    private static boolean isOperation(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/';
    }
}
