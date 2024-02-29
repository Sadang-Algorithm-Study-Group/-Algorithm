package week01.pgs12906;

import java.util.*;

/**
 * 문제: 같은 숫자는 싫어
 */

public class Main {

    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.empty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
