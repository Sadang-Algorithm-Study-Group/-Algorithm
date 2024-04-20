/**
 *  선분 위의 점
 *  https://www.acmicpc.net/problem/11663
 *  [ 효율성 ]
 *  - 메모리: 258872KB
 *  - 시간 : 2848ms
 */

package week08.boj11663;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] array = new int[n];

        Arrays.setAll(array, i -> scanner.nextInt());
        Arrays.sort(array);
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt(), end = scanner.nextInt();
            int lowerBoundIndex = lowerBound(array, start);
            int upperBoundIndex = upperBound(array, end);

            System.out.println(upperBoundIndex - lowerBoundIndex);
        }
        scanner.close();
    }

    private static int lowerBound(int[] array, int target) {
        int left = 0, right = array.length;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static int upperBound(int[] array, int target) {
        int left = 0, right = array.length;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (target >= array[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
