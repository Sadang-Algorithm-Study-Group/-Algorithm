package P2024_01;

import java.util.*;

public class B_13335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //4
        int w = sc.nextInt(); //2
        int l = sc.nextInt(); //10

        LinkedList<Integer> queue = new LinkedList<>() {
            {
                for (int i = 0; i < n; i++) {
                    offer(sc.nextInt());
                }
            }
        };

        LinkedList<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.offer(0); // 다리 초기화
        }

        int time = 0;
        int currentWeight = 0; // 현재 다리 위의 총 무게

        while (!bridge.isEmpty()) {
            time++;
            currentWeight -= bridge.poll(); // 맨 앞의 트럭이 다리를 떠남

            if (!queue.isEmpty()) {
                if (currentWeight + queue.peek() <= l) { // 다리에 새로운 트럭이 올라갈 수 있는 경우
                    int nextTruck = queue.poll();
                    bridge.offer(nextTruck);
                    currentWeight += nextTruck;
                } else {
                    bridge.offer(0); // 다리에 트럭이 올라갈 수 없으면 0을 추가하여 시간 유지
                }
            }
        }

        System.out.println(time);

        sc.close();
    }
}
