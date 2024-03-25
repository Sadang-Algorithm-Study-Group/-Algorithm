/**
 *  리모컨
 *  https://www.acmicpc.net/problem/1107
 *  [ 효율성 ]
 *  - 메모리: 20060KB
 *  - 시간 : 300ms
 */

package week04.boj1107;

import java.util.*;

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
        int answer = Math.abs(n - 100); // 100부터 시작하도록 수정

        for (int i = 0; i <= 1000000; i++) { // 모든 가능한 채널에 대해 검사
            int count = i == 0 ? set.contains(0) ? 0 : 1 : possible(i, set); // i 채널까지 버튼을 몇 번 눌러야 하는지 계산

            if (count > 0) {
                int press = Math.abs(n - i); // 채널 i에서 n까지 버튼을 몇 번 눌러야 하는지 계산
                answer = Math.min(answer, count + press);
            }
        }
        System.out.println(answer);
        scanner.close();
    }

    // 주어진 채널로 이동 가능한지 여부를 반환하는 함수
    public static int possible(int channel, Set<Integer> set) {
        int count = 0;

        while (channel > 0) {
            if (set.contains(channel % 10)) return 0;
            channel /= 10;
            count++;
        }
        return count;
    }
}

/**
 *  리모컨
 *  https://www.acmicpc.net/problem/1107
 *  아래코드는 제출 못함(정답이 아님)
 */

/*import java.util.*;
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
}*/