package P2024_01;

import java.util.*;

public class P_42883 {
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;

        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            System.out.print(c + " ");
            while(!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            System.out.print(stack);
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
