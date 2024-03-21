/**
 *  숫자 정사각형
 *  https://www.acmicpc.net/problem/1051
 *  [ 효율성 ]
 *  - 메모리: 17816KB
 *  - 시간 : 224ms
 */

package week04.boj1051;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        char[][] arrays = new char[n][m];
        int size = 1;

        Arrays.setAll(arrays, i -> scanner.next().toCharArray());
        for (int i = 0; i < Math.min(n, m); i++) {
            size = Math.max(size, linearSearchAndGetSize(arrays, i));
        }
        System.out.println(size * size);
        scanner.close();
    }

    private static int linearSearchAndGetSize(char[][] arrays, int size) {
        for (int i = 0; i < arrays.length - size; i++) {
            for (int j = 0; j < arrays[i].length - size; j++) {
                if (arrays[i][j] == arrays[i][j + size] && arrays[i][j] == arrays[i + size][j] && arrays[i][j] == arrays[i + size][j + size]) {
                    return size + 1;
                }
            }
        }
        return 1;
    }
}
