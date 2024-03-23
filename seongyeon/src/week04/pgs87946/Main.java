package week04.pgs87946;

import static java.lang.Math.max;

/**
 * 문제: 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */

public class Main {

    private int result = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        check(dungeons, visited, k, 0);
        return result;
    }

    private void check(int[][] dungeons, boolean[] visited, int k, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            int threshold = dungeons[i][0];
            int cost = dungeons[i][1];

            if (!visited[i] && threshold <= k) {
                visited[i] = true;
                check(dungeons, visited, k - cost, depth + 1);
                visited[i] = false;
            }
        }

        result = max(result, depth);
    }
}
