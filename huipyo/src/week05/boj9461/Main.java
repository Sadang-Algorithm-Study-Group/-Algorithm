/**
 *  파도반 수열
 *  https://www.acmicpc.net/problem/9461
 *  [ 효율성 ]
 *  - 메모리: 17788KB
 *  - 시간 : 220ms
 */

package week05.boj9461;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println(p(Integer.parseInt(scanner.nextLine())));
        }
        scanner.close();
    }

    static long p(int i) {
        long[] init = new long[] {1, 1, 1, 2, 2};

        if (i > 5) {
            long[] array = new long[i];

            System.arraycopy(init, 0, array, 0, init.length);
            for (int j = 5; j < array.length; j++) {
                array[j] = array[j - 1] + array[j - 5];
            }
            return array[i - 1];
        } else {
            return init[i - 1];
        }
    }
}