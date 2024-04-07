/**
 *  상자의 균형
 *  https://www.acmicpc.net/problem/20116
 *  [ 효율성 ]
 *  - 메모리: 180532KB
 *  - 시간 : 1144ms
 */

package week06.boj20116;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long l = scanner.nextLong();
        long[] array = new long[n + 1];
        long s = 0, count = 0;

        Arrays.setAll(array, i -> i == 0 ? i : scanner.nextLong());
        for (int i = n; i >= 2; i--) {
            s += array[i];
            count++;
            long L = (array[i - 1] - l) * count;
            long R = (array[i - 1] + l) * count;

            if (L >= s || s >= R) {
                System.out.println("unstable");
                return;
            }
        }
        System.out.println("stable");
        scanner.close();
    }
}
