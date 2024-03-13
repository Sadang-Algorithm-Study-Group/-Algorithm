package week02.boj26042;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int first = scanner.nextInt();

            if (first == 1) {
                int second = scanner.nextInt();

                queue.offer(second);
                list.add(new ArrayList<>(queue));
            } else {
                queue.poll();
            }
        }
        list.sort((o1, o2) -> o1.size() != o2.size() ? o2.size() - o1.size() : o1.get(o1.size() - 1) - o2.get(o2.size() - 1));
        System.out.println(list.get(0).size() + " " + list.get(0).get(list.get(0).size() - 1));
        scanner.close();
    }
}