package Week1.Example;

import java.util.Stack;

public class CorrectParentheses {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    stack.push(chars[i]);
                } else {
                    if (stack.search('(') != -1) {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty() && i == chars.length - 1) {
                answer = true;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new CorrectParentheses().solution("(()("));
    }
}
