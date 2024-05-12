package week10.boj1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 문제: 친구
 *
 * 아직 못 풀었다.
 */

public class Main {

    static Set<Integer> friends = new HashSet<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            char[][] graph = new char[n][n];

            for (int i = 0; i < n; i++) {
                graph[i] = reader.readLine().toCharArray();
            }

            System.out.println(solution(n, graph));
        }
    }

    private static int solution(int n, char[][] graph) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            answer = Math.max(friends.size(), answer);
            friends.clear();

            visited[i] = true;
            dfs(i, 0, graph, visited, n);
            visited[i] = false;
        }

        if (answer == 0) {
            return 0;
        }
        return answer - 1;
    }

    private static void dfs(int current, int count, char[][] graph, boolean[] visited, int n) {
        friends.add(current);

        if (count == 2) {
            return;
        }

        for (int next = 0; next < n; next++) {
            if (graph[current][next] == 'Y' && !visited[next]) {
                visited[next] = true;
                dfs(next, count + 1, graph, visited, n);
                visited[next] = false;
            }
        }
    }
}
