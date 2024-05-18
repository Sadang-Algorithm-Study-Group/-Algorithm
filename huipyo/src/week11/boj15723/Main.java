/**
 *  n단 논법
 *  https://www.acmicpc.net/problem/15723
 *  [ 효율성 ]
 *  - 메모리: 17692KB
 *  - 시간 : 220ms
 */

package week11.boj15723;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, List<String>> graph = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    String a = scanner.next();
                    String is = scanner.next();
                    String b = scanner.next();

                    computeIfAbsent(a, character -> new ArrayList<>())
                            .add(b);
                }
            }
        };
        int m = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            String a = scanner.next();
            String is = scanner.next();
            String b = scanner.next();

            System.out.println(bfs(graph, a, b) ? "T" : "F");
        }
        scanner.close();
    }

    private static boolean bfs(Map<String, List<String>> graph, String a, String b) {
        Queue<String> queue = new ArrayDeque<>(List.of(a));
        Set<String> visited = new HashSet<>(List.of(a));

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(b)) {
                return true;
            }
            for (String next : graph.getOrDefault(current, Collections.emptyList())) {
                if (visited.contains(next)) continue;
                visited.add(next);
                queue.offer(next);
            }
        }
        return false;
    }
}
