package P2024_01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class B_16815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");
        AtomicBoolean foundStar = new AtomicBoolean(false); // '*' 발견 여부
        AtomicBoolean starInsideParentheses = new AtomicBoolean(false); // '*'가 괄호 안에 있는지 여부

        Stack<String> stack = new Stack<>() {{
            Arrays.stream(str).forEach(s -> {
                switch (s) {
                    case "(":
                        push(s);
                        break;
                    case "*":
                        if (!isEmpty() && peek().equals("(")) {
                            // 스택이 비어있지 않고, 스택의 맨 위에 '('가 있다면 '*'는 괄호 안에 있는 것
                            foundStar.set(true);
                            starInsideParentheses.set(true);
                        } else {
                            // 괄호 안에 '*'가 없으면
                            foundStar.set(true);
                            starInsideParentheses.set(false);
                        }
                        break;
                    case ")":
                        if (!isEmpty() && peek().equals("(")) {
                            pop(); // '('와 짝을 이루는 ')' 발견 시 스택에서 '(' 제거
                            push("()"); // 괄호 쌍을 유효한 것으로 표시
                        }
                        break;
                }
            });
        }};

        long valid = stack.stream().filter("()"::equals).count();
        if (foundStar.get() && !starInsideParentheses.get()) {
            System.out.println(0);
        } else {
            System.out.println(valid);
        }
        sc.close();
    }
}

//    Scanner sc = new Scanner(System.in);
//    String[] str = sc.nextLine().split("");
//    Stack<String> stack = new Stack<>();
//
//        for (int i = 0; i < str.length; i++) {
//        if (str[i].equals("(")) {
//        stack.push(str[i]);
//        } else if (str[i].equals("*")) {
//        continue;
//        } else if (str[i].equals(")")) {
//        if (!stack.isEmpty() && stack.peek().equals("(")) {
//        stack.pop();
//        stack.push("()");
//        }
//        }
//        }
//
//        int validPairs = 0;
//        for (String element : stack) {
//        if (element.equals("()")) {
//        validPairs++;
//        }
//        }
//
//        System.out.println(validPairs);
//        sc.close();