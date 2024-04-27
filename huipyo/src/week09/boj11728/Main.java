/**
 *  배열 합치기
 *  https://www.acmicpc.net/problem/11728
 *  [ 효율성 ]
 *  - 메모리: 443356KB
 *  - 시간 : 3552ms
 */

package week09.boj11728;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        String[] array = new String[n + m];

        Arrays.setAll(array, i -> scanner.next());
        Arrays.sort(array, Comparator.comparingInt(Integer::parseInt));
        System.out.println(String.join(" ", array));
        scanner.close();
    }
}
