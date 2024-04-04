/**
 *  개똥벌레
 *  https://www.acmicpc.net/problem/3020
 *  [ 효율성 ]
 *  - 메모리: 초과
 */


package week06.boj3020;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), h = scanner.nextInt();
        int[][] array = new int[h][n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();

            if (i % 2 == 0) {
                for (int j = h - 1; j > h - 1 - input; j--) {
                    array[j][i] = 1;
                }
            } else {
                for (int j = 0; j < input; j++) {
                    array[j][i] = 1;
                }
            }
        }
        for (int[] intArray : array) {
            int count = 0;

            for (int anInt : intArray) {
                if (anInt == 1) count++;
            }
            result[count]++;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                System.out.println(i + " " + result[i]);
                break;
            }
        }
    }
}