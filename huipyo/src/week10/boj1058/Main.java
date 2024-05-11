package week10.boj1058;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] array = new char[n][];
        Map<Integer, Set<Integer>> graph = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    array[i] = scanner.next().toCharArray();

                    for (int j = 0; j < array[i].length; j++) {
                        if (array[i][j] == 'Y') {
                            computeIfAbsent(i, a -> new HashSet<>()).add(j);
                        }
                    }
                }
            }
        };
        Set<Integer> visited = new HashSet<>();
        Consumer<Integer> dfs = new Consumer<>() {

            @Override
            public void accept(Integer start) {
                visited.add(start);
                for (int next : graph.getOrDefault(start, Collections.emptySet())) {
                    if (!visited.contains(next)) {
                        accept(next);
                        visited.add(next);
                    }
                }
            }
        };
        int answer = 0;

        for (int i = 0; i < n; i++) {
            visited.clear();
            dfs.accept(i);
            answer = Math.max(answer, visited.size()) - 1;
        }
        System.out.println(answer);
        scanner.close();
    }
}
