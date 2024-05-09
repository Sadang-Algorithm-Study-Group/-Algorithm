/*
 틀렸다고 나옴 추후 해결
 */

package week10.pgs258711;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[][] {
                {2, 3}, {4, 3}, {1, 1}, {2, 1}
        })));
        System.out.println(Arrays.toString(new Solution().solution(new int[][] {
                {4, 11},
                {1, 12},
                {8, 3},
                {12, 7},
                {4, 2},
                {7, 11},
                {4, 8},
                {9, 6},
                {10, 11},
                {6, 10},
                {3, 5},
                {11, 1},
                {5, 3},
                {11, 9},
                {3, 8}
        })));
    }
}

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, List<Integer>> graph = new HashMap<>() {
            {
                for (int[] edge : edges) {
                    computeIfAbsent(edge[0], i -> new ArrayList<>()).add(edge[1]);
                }
            }
        };

        for (int[] edge : edges) {
            if (graph.get(edge[0]).size() > 1) {
                answer[0] = edge[0];
                break;
            }
        }
        for (int next : graph.get(answer[0])) {
            answer[bfs(graph, next)]++;
        }
        return answer;
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>(List.of(start));
        int n = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            n++;
            if (n > 1 && current == start) return 1;
            for (int next : graph.getOrDefault(current, Collections.emptyList())) {
                if (graph.get(next).size() > 1) return 3;
                queue.offer(next);
            }
        }
        return 2;
    }
}