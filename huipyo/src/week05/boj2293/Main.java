/**
 *  동전 1
 *  https://www.acmicpc.net/problem/2293
 *  [ 효율성 ]
 *  - 메모리: 17772KB
 *  - 시간 : 220ms
 */

package week05.boj2293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] array = new int[k + 1];
        array[0] = 1;

        for (int i = 1; i <= n; i++) {
            int input = scanner.nextInt();

            for (int j = input; j <= k; j++) {
                array[j] += array[j - input];
            }
        }
        System.out.println(array[k]);
        scanner.close();
    }
}
