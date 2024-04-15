/**
 *  가장 긴 증가하는 부분 수열 2
 *  https://www.acmicpc.net/problem/12015
 *  [ 효율성 ]
 *  - 메모리: 329128KB
 *  - 시간 : 1924ms
 */

package week08.boj12015;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int[] memo = new int[n];
        int count = 0;

        Arrays.setAll(array, i -> scanner.nextInt());
        for (int num : array) {
            int result = Arrays.binarySearch(memo, 0, count, num);
            int index = Math.max(result, -(result + 1));
            memo[index] = num;

            if (index == count) count++;
        }
        System.out.println(count);
        scanner.close();
    }
}
