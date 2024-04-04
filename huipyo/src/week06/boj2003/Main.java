/**
 *  수들의 합 2
 *  https://www.acmicpc.net/problem/2003
 *  [ 효율성 ]
 *  - 메모리: 29688KB
 *  - 시간 : 464ms
 */

package week06.boj2003;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[n];
        int count = 0;

        Arrays.setAll(array, i -> scanner.nextInt());
        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += array[j];
                if (sum == m) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}