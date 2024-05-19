/**
 *  파티
 *  https://www.acmicpc.net/problem/1238
 *  [ 효율성 ]
 *  - 메모리: 216708KB
 *  - 시간 : 1756ms
 */

package week11.boj1238;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), x = scanner.nextInt();
        Map<Integer, List<SimpleEntry<Integer, Integer>>> graph = new HashMap<>() {
            {
                for (int i = 0; i < m; i++) {
                    int[] inputs = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};

                    computeIfAbsent(inputs[0], integer -> new ArrayList<>())
                            .add(new SimpleEntry<>(inputs[1], inputs[2]));
                }
            }
        };
        int answer = 0;

        for (int start : graph.keySet()) {
            if (start != x) {
                answer = Math.max(answer, dijkstra(graph, start, x) + dijkstra(graph, x, start));
            }
        }
        System.out.println(answer);
        scanner.close();
    }

    private static int dijkstra(Map<Integer, List<SimpleEntry<Integer, Integer>>> graph, int start, int dest) {
        PriorityQueue<SimpleEntry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(SimpleEntry::getValue)) {
            {
                offer(new SimpleEntry<>(start, 0));
            }
        };
        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            SimpleEntry<Integer, Integer> current = pq.poll();

            if (current.getKey() == dest) return current.getValue();
            visited.add(current.getKey());
            for (SimpleEntry<Integer, Integer> next : graph.getOrDefault(current.getKey(), Collections.emptyList())) {
                if (visited.contains(next.getKey())) continue;
                pq.offer(new SimpleEntry<>(next.getKey(), next.getValue() + current.getValue()));
            }
        }
        return 0;
    }
}
