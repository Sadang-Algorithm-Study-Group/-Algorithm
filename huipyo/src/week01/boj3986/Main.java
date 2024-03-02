package week01.boj3986;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            LinkedList<Character> stack = new LinkedList<>();

            for (char ch : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) stack.pop();
                else stack.push(ch);
            }
            if (stack.isEmpty()) answer++;
        }
        System.out.println(answer);
        scanner.close();
    }
}