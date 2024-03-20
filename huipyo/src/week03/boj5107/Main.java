/**
 *  마니또
 *  https://www.acmicpc.net/problem/5107
 *  [ 효율성 ]
 *  - 메모리: 18552KB
 *  - 시간 : 240ms
 */

package week03.boj5107;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, no = 1;

        while ((n = scanner.nextInt()) != 0) {
            int count = 0;
            Map<String, List<String>> graph = initGraph(n, scanner);
            Set<String> visited = new HashSet<>();
            Consumer<String> bfs = start -> {
                Queue<String> queue = new ArrayDeque<>(List.of(start));

                while (!queue.isEmpty()) {
                    String current = queue.poll();

                    for (String next : graph.get(current)) {
                        if (visited.contains(next)) continue;
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            };

            for (String s : graph.keySet()) {
                if (!visited.contains(s)) {
                    bfs.accept(s);
                    count++;
                }
            }
            System.out.println(no++ + " " + count);
        }
        scanner.close();
    }

    private static Map<String, List<String>> initGraph(int n, Scanner scanner) {
        return new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    String first = scanner.next(), second = scanner.next();

                    computeIfAbsent(first, s -> new ArrayList<>()).add(second);
                    computeIfAbsent(second, s -> new ArrayList<>()).add(first);
                }
            }
        };
    }
}
