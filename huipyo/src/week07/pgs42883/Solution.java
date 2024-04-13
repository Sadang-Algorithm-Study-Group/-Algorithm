package week07.pgs42883;

import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<String> stack = new Stack<>();
        int removeCount = 0;

        for (String ch : number.split("")) {
            while (!stack.isEmpty() && removeCount < k && stack.peek().charAt(0) < ch.charAt(0)) {
                stack.pop();
                removeCount++;
            }
            if (stack.size() < number.length() - k) {
                stack.push(ch);
            }
        }
        return String.join("", stack);
    }
}
