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
            if (graph.getOrDefault(edge[0], Collections.emptyList()).size() > 1) {
                answer[0] = edge[0];
                break;
            }
        }
        for (int next : graph.getOrDefault(answer[0], Collections.emptyList())) {
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
                if (graph.getOrDefault(next, Collections.emptyList()).size() > 1) return 3;
                queue.offer(next);
            }
        }
        return 2;
    }
}
/*
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
        int start2 = 0;
        Map<Integer, List<Integer>> graph2 = new HashMap<>() {
            {
                for (int[] edge : edges) {
                    computeIfAbsent(edge[0], i -> new ArrayList<>()).add(edge[1]);
                }
            }
        };

        for (int[] edge : edges) {
            if (graph2.get(edge[0]).size() > 1) {
                start2 = edge[0];
                break;
            }
        }
        System.out.println(start2);
        System.out.println("------");
        List<Integer>[] graph = new ArrayList[101];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] answer = new int[4];
        int[] inN = new int[101];
        int[] outN = new int[101];

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            inN[end]++;
            outN[start]++;

            graph[start].add(end);
        }
        System.out.println(graph2);
        System.out.println(Arrays.toString(graph));
        System.out.println(Arrays.toString(inN));
        System.out.println(Arrays.toString(outN));
        for (int i = 0; i < 101; i++) {
            if (inN[i] == 0 && outN[i] > 1) {
                answer[0] = i;
                break;
            }
        }

        for (int neighbor : graph2.get(answer[0])) {
            answer[bfs(graph2, neighbor)]++;
        }

        return answer;
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        int n = 0;

        queue.offer(start);

        while (!queue.isEmpty()) {
            int p = queue.poll();
            n++;

            if (n > 1 && p == start) {
                return 1;
            }

            for (int neighbor : graph.getOrDefault(p, Collections.emptyList())) {
                if (graph.get(neighbor).size() > 1) {
                    return 3;
                }
                queue.offer(neighbor);
            }
        }

        return 2;
    }
}
*/