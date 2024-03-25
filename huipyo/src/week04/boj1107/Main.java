/**
 *  리모컨
 *  https://www.acmicpc.net/problem/1107
 *  제출 못함(정답이 아님)
 */

package week04.boj1107;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<Integer> set = new HashSet<>(m) {
            {
                for (int i = 0; i < m; i++) {
                    add(scanner.nextInt());
                }
            }
        };
        int answer = 0;

        if (n != 100) {
            while (n > 0) {
                int remainder = n % 10;
                int minOfCalculate = getMinOfCalculate(remainder, set);
                answer += minOfCalculate;
                n /= 10;
            }
        }
        System.out.println(answer);
        scanner.close();
    }

    private static int calculate(int num, Set<Integer> set, Function<Integer, Integer> function) {
        int count = 1;

        while (num % 10 != 0) {
            if (!set.contains(num)) break;
            else {
                num = function.apply(num);
                count++;
            }
        }
        return count;
    }

    private static int getMinOfCalculate(int remainder, Set<Integer> set) {
        int increase = calculate(remainder, set, integer -> integer + 1);
        int decrease = calculate(remainder, set, integer -> integer - 1);
        return Math.min(increase, decrease);
    }
}
