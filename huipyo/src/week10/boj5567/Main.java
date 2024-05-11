/**
 *  결혼식
 *  https://www.acmicpc.net/problem/5567
 *  [ 효율성 ]
 *  - 메모리: 38268KB
 *  - 시간 : 536ms
 */

package week10.boj5567;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>() {
            {
                for (int i = 0; i < m; i++) {
                    int[] input = {scanner.nextInt(), scanner.nextInt()};

                    computeIfAbsent(input[0], a -> new ArrayList<>()).add(input[1]);
                    computeIfAbsent(input[1], a -> new ArrayList<>()).add(input[0]);
                }
            }
        };
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new ArrayDeque<>(List.of(new AbstractMap.SimpleEntry<>(1, 1)));
        Set<Integer> visited = new HashSet<>(List.of(1));
        int count = 0;

        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> current = queue.poll();

            if (current.getValue() > 3) break;
            count++;
            for (int next : graph.getOrDefault(current.getKey(), Collections.emptyList())) {
                if (visited.contains(next)) continue;
                visited.add(next);
                queue.offer(new AbstractMap.SimpleEntry<>(next, current.getValue() + 1));
            }
        }
        System.out.println(count - 1);
        scanner.close();
    }
}

/*
3
2
1 3
2 3
ans: 2

4
3
1 2
2 3
3 4
ans: 2
 */