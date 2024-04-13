/**
 *  에너지 드링크
 *  https://www.acmicpc.net/problem/20115
 *  [ 효율성 ]
 *  - 메모리: 109040KB
 *  - 시간 : 1192ms
 */

package week07.boj20115;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] array = new Integer[n];
        double sum = 0;

        Arrays.setAll(array, i -> scanner.nextInt());
        Arrays.sort(array, (a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            sum += (double) array[i] / (i == 0 ? 1 : 2);
        }
        System.out.println(sum);
        scanner.close();
    }
}