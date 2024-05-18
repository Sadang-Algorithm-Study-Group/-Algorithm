package week11.boj1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {

        private final int index;
        private final int time;

        Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    private static long solution(int n, int x, ArrayList<Node>[] graph) {
        long[] times = calculateTime(n, x, graph); // x -> 다른 노드들

        for (int i = 0; i < n + 1; i++) {
            long currentToX = calculateTime(n, i, graph)[x];
            times[i] += currentToX;
        }

        long max = 0;
        for (long time : times) {
            max = Math.max(time, max);
        }

        return max;
    }

    private static long[] calculateTime(int n, int start, ArrayList<Node>[] graph) {
        boolean[] visited = new boolean[n + 1];
        long[] times = new long[n + 1];
        Arrays.fill(times, Integer.MAX_VALUE);
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start, 0));
        times[start] = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();

            // 방문 처리
            if (visited[current.index]) {
                continue;
            }
            visited[current.index] = true;

            for (Node next : graph[current.index]) {
                if (!visited[next.index] && (times[current.index] + next.time) < times[next.index]) {
                    times[next.index] = times[current.index] + next.time;

                    q.offer(next);
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            if (times[i] == Integer.MAX_VALUE) {
                times[i] = 0;
            }
        }

        return times;
    }

    // ----- 입출력 -----
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());

            ArrayList<Node>[] graph = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                int time = Integer.parseInt(tokenizer.nextToken());

                graph[start].add(new Node(end, time));
            }

            System.out.println(solution(n, x, graph));
        }
    }
}
