/**
 *  Star in Parentheses
 *  https://www.acmicpc.net/problem/16815
 *  [ 효율성 ]
 *  - 메모리: 17572KB
 *  - 시간 : 196ms
 */

package week01.boj16815;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        new LinkedList<Character>() {
            {
                for (char c : s.toCharArray()) {
                    switch (c) {
                        case '(':
                            push(c);
                            break;
                        case ')':
                            if (!isEmpty() && peek() == '(') pop();
                            else push(c);
                            break;
                        case '*':
                            System.out.println(size());
                            break;
                    }
                }
            }
        };
        scanner.close();
    }
}
