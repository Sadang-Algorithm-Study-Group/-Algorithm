package week11.boj1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제: 지름길
 * 메모리: 14320 KB
 * 시간: 124 ms
 *
 * https://www.acmicpc.net/problem/1446
 */

public class Main {

    static class Node {

        private final int index;
        private final int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    private static int solution(int d, ArrayList<Node>[] graph) {
        boolean[] visited = new boolean[d + 1];
        int[] distances = new int[d + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        for (int i = 0; i < d; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;

            // 다음 수 초기화
            if(distances[i+1] > distances[i] + 1) {
                distances[i+1] = distances[i] + 1;
            }

            for (Node node : graph[i]) {
                if (distances[i] + node.cost < distances[node.index]) {
                    distances[node.index] = distances[i] + node.cost;
                }
            }
        }

        return distances[d];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            ArrayList<Node>[] graph = new ArrayList[d + 1];
            for (int i = 0; i < d + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                int cost = Integer.parseInt(tokenizer.nextToken());

                // 역주행이 불가함 -> 도착 지점이 d 보다 큰 수 필요 없음
                if (d < end) {
                    continue;
                }

                graph[start].add(new Node(end, cost));
            }

            System.out.println(solution(d, graph));
        }
    }
}
