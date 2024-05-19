package week11.boj18352;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt(), x = scanner.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>() {
            {
                for (int i = 0; i < m; i++) {
                    computeIfAbsent(scanner.nextInt(), integer -> new ArrayList<>()).add(scanner.nextInt());
                }
            }
        };
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue()) {
            {
                offer(new AbstractMap.SimpleEntry<>(x, 0));
            }
        };
        Set<Integer> visited = new HashSet<>(List.of(x));
        List<String> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> current = queue.poll();

            if (current.getValue() == k) answer.add(String.valueOf(current.getKey()));
            visited.add(current.getKey());
            for (int next : graph.getOrDefault(current.getKey(), Collections.emptyList())) {
                if (visited.contains(next)) continue;
                queue.offer(new AbstractMap.SimpleEntry<>(next, current.getValue() + 1));
            }
        }
        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            answer.sort(Comparator.comparingInt(Integer::parseInt));
            System.out.println(String.join("\n", answer));
        }
        scanner.close();
    }
}
