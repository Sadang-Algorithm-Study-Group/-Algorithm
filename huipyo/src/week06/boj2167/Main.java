/**
 *  2차원 배열의 합
 *  https://www.acmicpc.net/problem/2167
 *  [ 효율성 ]
 *  - 메모리: 130504KB
 *  - 시간 : 1240ms
 */

package week06.boj2167;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] array = initArray(scanner, n, m);
        int[][] prefixSumArray = new int[n][m];
        int k = scanner.nextInt();

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                prefixSumArray[a][b] = array[a][b] + (a > 0 ? prefixSumArray[a - 1][b] : 0) + (b > 0 ? prefixSumArray[a][b - 1] : 0) - (a > 0 && b > 0 ? prefixSumArray[a - 1][b - 1] : 0);
            }
        }
        for (int c = 0; c < k; c++) {
            int i = scanner.nextInt() - 1;
            int j = scanner.nextInt() - 1;
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println(prefixSumArray[x - 1][y - 1] - (i > 0 ? prefixSumArray[i - 1][y - 1] : 0) - (j > 0 ? prefixSumArray[x - 1][j - 1] : 0) + (i > 0 && j > 0 ? prefixSumArray[i - 1][j - 1] : 0));
        }
        scanner.close();
    }

    private static int[][] initArray(Scanner scanner, int n, int m) {
        int[][] array = new int[n][m];

        Arrays.setAll(array, i -> {
            int[] row = new int[m];

            Arrays.setAll(row, j -> scanner.nextInt());
            return row;
        });
        return array;
    }
}