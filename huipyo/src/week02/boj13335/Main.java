package week02.boj13335;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), w = scanner.nextInt(), l = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>() {
            {
                for (int i = 0; i < n; i++) offer(scanner.nextInt());
            }
        };
        Queue<Integer> queue = new ArrayDeque<>();
        int answer = 0;

        while (!deque.isEmpty()) {
            Integer current = deque.peek();
            answer++;
            if (current != null && isNotExceeded(new ArrayList<>(queue), current, l) && queue.size() <= w) {
                queue.offer(deque.poll());
            } else if (!queue.isEmpty()) {
                queue.poll();
            }
            System.out.println(current + ", " + deque + ", " + queue + ", answer1: " + answer);
        }
        while (!queue.isEmpty()) {
            answer++;
            queue.poll();
            System.out.println(deque + ", " + queue + ", answer2: " + answer);
        }
        System.out.println(answer);
        scanner.close();
    }

    private static boolean isNotExceeded(List<Integer> list, int current, int limit) {
        int sum = 0;

        for (Integer integer : list) sum += integer;
        return sum + current <= limit;
    }
}