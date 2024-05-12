/**
 *  토마토
 *  https://www.acmicpc.net/problem/7569
 *  [ 효율성 ]
 *  - 메모리: 325896KB
 *  - 시간 : 1880ms
 */

package week10.boj7569;

import java.util.*;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt(), h = scanner.nextInt();
        List<int[]> startList = new ArrayList<>();
        int[][][] array = ((Supplier<int[][][]>) () -> {
            int[][][] result = new int[h][n][m];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        int input = scanner.nextInt();
                        result[i][j][k] = input;

                        if (input == 1) startList.add(new int[] {i, j, k});
                    }
                }
            }
            return result;
        }).get();
        int answer = 0;

        bfs(array, startList);
        for (int[][] ints : array) {
            for (int[] anInt : ints) {
                Arrays.sort(anInt);
                if (Arrays.binarySearch(anInt, 0) > -1) {
                    System.out.println(-1);
                    return;
                } else {
                    answer = Math.max(answer, anInt[anInt.length - 1]);
                }
            }
        }
        System.out.println(answer - 1);
        scanner.close();
    }

    private static void bfs(int[][][] array, List<int[]> startList) {
        Queue<int[]> queue = new LinkedList<>(startList);

        while (!queue.isEmpty()) {
            int[] outed = queue.poll();

            for (int[] next : new int[][] {
                    {outed[0] + 1, outed[1], outed[2]},
                    {outed[0] - 1, outed[1], outed[2]},
                    {outed[0], outed[1] + 1, outed[2]},
                    {outed[0], outed[1] - 1, outed[2]},
                    {outed[0], outed[1], outed[2] + 1},
                    {outed[0], outed[1], outed[2] - 1}
            }) {
                if (next[0] > -1 && next[0] < array.length && next[1] > -1 && next[1] < array[0].length && next[2] > -1 && next[2] < array[0][0].length) {
                    if (array[next[0]][next[1]][next[2]] == 0) {
                        array[next[0]][next[1]][next[2]] = array[outed[0]][outed[1]][outed[2]] + 1;

                        queue.offer(next);
                    }
                }
            }
        }
    }
}
