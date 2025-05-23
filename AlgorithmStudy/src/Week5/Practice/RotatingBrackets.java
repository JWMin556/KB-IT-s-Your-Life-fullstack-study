package Week5.Practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class RotatingBrackets {
    public static boolean isRightString(String s) {
        boolean answer = false;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            }

            if (stack.isEmpty()) {
                break;
            } else {
                if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }

            if (i == s.length() - 1 && stack.isEmpty()) { answer = true; }
        }
        return answer;
    }

    public static int solution(String s) {
        int answer = 0;
        String[] arr = new String[s.length()];
        arr[0] = s;
        for (int i = 1; i < s.length(); i++) {
            String temp1 = s.substring(0, i);
            String temp2 = s.substring(i);
            arr[i] =  temp2 + temp1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (isRightString(arr[i])) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }
}
