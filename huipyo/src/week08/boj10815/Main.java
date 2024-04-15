/**
 *  숫자 카드
 *  https://www.acmicpc.net/problem/10815
 *  [ 효율성 ]
 *  - 메모리: 368968KB
 *  - 시간 : 2412ms
 */

package week08.boj10815;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    int input = scanner.nextInt();

                    put(input, input);
                }
            }
        };
        int m = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        for (int j = 0; j < m; j++) {
            stringBuilder.append(map.getOrDefault(scanner.nextInt(), 0) != 0 ? 1: 0);
            if (j < m - 1) stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
        scanner.close();
    }
}