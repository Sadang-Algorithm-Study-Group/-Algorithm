/**
 *  ABCDE
 *  https://www.acmicpc.net/problem/13023
 *  [ 효율성 ]
 *  - 메모리: 92900KB
 *  - 시간 : 684ms
 */

package week10.boj13023;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        AtomicBoolean answer = new AtomicBoolean(false);
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>() {
            {
                for (int i = 0; i < m; i++) {
                    int[] input = {scanner.nextInt(), scanner.nextInt()};

                    computeIfAbsent(input[0], a -> new ArrayList<>()).add(input[1]);
                    computeIfAbsent(input[1], b -> new ArrayList<>()).add(input[0]);
                }
            }
        };
        BiConsumer<Integer, Integer> dfs = new BiConsumer<>() {
            @Override
            public void accept(Integer current, Integer depth) {
                visited[current] = true;

                if (depth == 4) {
                    answer.set(true);
                    return;
                }
                for (int next : graph.getOrDefault(current, Collections.emptyList())) {
                    if (!visited[next] && !answer.get()) {
                        accept(next, depth + 1);
                        visited[next] = false;
                    }
                }
            }
        };

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            dfs.accept(i, 0);
            if (answer.get()) {
                break;
            }
        }
        System.out.println(answer.get() ? 1 : 0);
        scanner.close();
    }
}
