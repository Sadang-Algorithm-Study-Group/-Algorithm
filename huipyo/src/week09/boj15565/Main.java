/**
 *  귀여운 라이언
 *  https://www.acmicpc.net/problem/15565
 *  [ 효율성 ]
 *  - 메모리: 325792KB
 *  - 시간 : 1464ms
 */

package week09.boj15565;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] array = initArray(n, scanner);
        int answer = Integer.MAX_VALUE;
        List<Integer> indexList = new ArrayList<>() {
            {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 1) add(i);
                }
            }
        };

        for (int i = 0; i <= indexList.size() - k; i++) {
            int start = indexList.get(i);
            int end = indexList.get(i + k - 1);
            answer = Math.min(answer, end - start + 1);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        scanner.close();
    }

    private static int[] initArray(int n, Scanner scanner) {
        int[] array = new int[n];

        Arrays.setAll(array, i -> scanner.nextInt());
        return array;
    }
}