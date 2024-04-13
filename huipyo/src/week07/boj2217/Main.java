/**
 *  로프
 *  https://www.acmicpc.net/problem/2217
 *  [ 효율성 ]
 *  - 메모리: 110716KB
 *  - 시간 : 980ms
 */

package week07.boj2217;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int answer = 0;

        Arrays.setAll(array, i -> scanner.nextInt());
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            answer = Math.max(array[i] * (n - i), answer);
        }
        System.out.println(answer);
        scanner.close();
    }
}