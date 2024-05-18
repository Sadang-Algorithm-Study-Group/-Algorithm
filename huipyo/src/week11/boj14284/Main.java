/**
 *  간선 이어가기 2
 *  https://www.acmicpc.net/problem/14284
 *  [ 효율성 ]
 *  - 메모리: 229784KB
 *  - 시간 : 1228ms
 */

package week11.boj14284;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Map<Integer, List<int[]>> graph = new HashMap<>() {
            {
                for (int i = 0; i < m; i++) {
                    int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();

                    computeIfAbsent(a, integer -> new ArrayList<>()).add(new int[] {b, c});
                    computeIfAbsent(b, integer -> new ArrayList<>()).add(new int[] {a, c});
                }
            }
        };
        int s = scanner.nextInt(), t = scanner.nextInt();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])) {
            {
                offer(new int[] {s, 0});
            }
        };
        Set<Integer> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();

            if (current[0] == t) {
                System.out.println(current[1]);
                break;
            }
            visited.add(current[0]);
            for (int[] next : graph.getOrDefault(current[0], Collections.emptyList())) {
                if (visited.contains(next[0])) continue;
                priorityQueue.offer(new int[] {next[0], next[1] + current[1]});
            }
        }
        scanner.close();
    }
}
