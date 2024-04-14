/**
 *  랜선 자르기
 *  https://www.acmicpc.net/problem/1654
 *  [ 효율성 ]
 *  - 메모리: 31500KB
 *  - 시간 : 504ms
 */

package week08.boj1654;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt(), n = scanner.nextInt();
        List<Long> list = new ArrayList<>() {
            {
                for (int i = 0; i < k; i++) add(scanner.nextLong());
            }
        };
        long left = 1, right = Collections.max(list);
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long total = getTotal(list, mid);

            if (total >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
        scanner.close();
    }

    private static long getTotal(List<Long> list, long div) {
        int result = 0;

        for (long e : list) {
            result += e / div;
        }
        return result;
    }
}
