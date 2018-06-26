package com.jarvan.algo.stack;

import java.util.Stack;

public class StackGetLongestPattern {
    public static void main(String[] args) {
        int len = GetLongestPattern("(()");
        System.out.println("最大匹配长度为：" + len);

    }

    public static int GetLongestPattern(String content) {
        char[] p = content.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int len = content.length();
        int answer = 0;
        int start = -1;//左括号的第一个位置
        for (int i = 0; i < len; i++) {
            if (p[i] == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    answer = i;
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        answer = Math.max(answer, i - start);
                    } else {
                        answer = Math.max(answer, i - stack.peek());
                    }

                }
            }
        }
        return answer;
    }
}
