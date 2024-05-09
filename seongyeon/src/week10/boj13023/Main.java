package week10.boj13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제: ABCDE
 * 메모리: 20872 KB
 * 시간: 304 ms
 * 링크: https://www.acmicpc.net/problem/13023
 */

public class Main {

    static boolean checkFriend = false;
    static ArrayList<Integer>[] friends; // 이중 배열로 풀면 시간 초과
    static int n;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            friends = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                friends[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());

                friends[a].add(b);
                friends[b].add(a);
            }

            System.out.println(solution());
        }
    }

    private static int solution() {
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(1, i, visited);
            visited[i] = false;

            if (checkFriend) {
                return 1;
            }
        }

        return 0;
    }

    private static void dfs(int depth, int current, boolean[] visited) {
        if (depth == 5) {
            checkFriend = true;
            return;
        }

        for (int friend : friends[current]) {
            if (!visited[friend]) {
                visited[friend] = true;
                dfs(depth + 1, friend, visited);
                visited[friend] = false;
            }
        }
    }
}
