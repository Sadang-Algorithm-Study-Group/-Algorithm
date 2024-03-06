/**
 *  회전하는 큐
 *  https://www.acmicpc.net/problem/1021
 *  [ 효율성 ]
 *  - 메모리: 17700KB
 *  - 시간 : 212ms
 */

package week02.boj1021;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Queue<Integer> queue = new ArrayDeque<>() { { for (int i = 0; i < m; i++) offer(scanner.nextInt()); } };
        Deque<Integer> deque = new ArrayDeque<>() { { for (int i = 0; i < n; i++) offer(i + 1); } };
        int count = 0;

        while (!queue.isEmpty()) {
            int target = queue.poll();
            int start = new ArrayList<>(deque).indexOf(target);
            int end = deque.size() - start;

            while (!deque.isEmpty() && target != deque.peekFirst()) {
                count++;
                if (start < end) deque.offerLast(deque.pollFirst());
                else deque.offerFirst(deque.pollLast());
            }
            deque.pollFirst();
        }
        System.out.println(count);
        scanner.close();
    }
}