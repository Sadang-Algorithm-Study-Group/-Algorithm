package week11.boj1446;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), d = scanner.nextInt();
        Map<Integer, List<AbstractMap.SimpleEntry<Integer, Integer>>> graph = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    computeIfAbsent(scanner.nextInt(), integer -> new ArrayList<>())
                            .add(new SimpleEntry<>(scanner.nextInt(), scanner.nextInt()));
                }
            }
        };
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getKey() - o1.getKey()) {
            {
                offer(Collections.min(graph.getOrDefault(0, Collections.emptyList()), Comparator.comparingInt(AbstractMap.SimpleEntry::getKey)));
            }
        };
        Set<Integer> visited = new HashSet<>();

        System.out.println(queue);
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> current = queue.poll();

            if (current.getKey() >= d) {
                break;
            }
            visited.add(current.getKey());
            for (AbstractMap.SimpleEntry<Integer, Integer> next : graph.getOrDefault(current.getKey(), Collections.emptyList())) {
                if (visited.contains(next.getKey())) continue;
                queue.offer(next);
            }
        }
        System.out.println(visited);
        System.out.println(graph);
        scanner.close();
    }
}
