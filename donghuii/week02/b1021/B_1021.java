package P2024_01;

import java.util.*;

/**
 * 메모리 : 17772
 * 시간 : 228
 */
public class B_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> list = new ArrayList<>() {
            {
                for (int i = 0; i < M; i++) {
                    add(sc.nextInt());
                }
            }
        };

        LinkedList<Integer> queue = new LinkedList<>() {
            {
                for (int i = 0; i < N; i++) {
                    offer(i + 1);
                }
            }
        };

        int sum = 0;

        for(int target : list) {
            while(true) {
                if(queue.peek().equals(target)) {
                    queue.poll();
                    break;
                } else {
                    int index = queue.indexOf(target);
                    int size = queue.size() / 2;
                    if(index <= size) {
                        queue.addLast(queue.pollFirst());
                        sum++;
                    } else {
                        queue.addFirst(queue.pollLast());
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
