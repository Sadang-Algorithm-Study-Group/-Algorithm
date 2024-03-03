package week01.pgs42583;

import java.util.*;

/**
 * 문제: 다리를 지나는 트럭
 */

public class Main {

    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(truck_weights[0]); // 초기 값

        int truckCount = truck_weights.length; // 편의를 위해 변수 사용
        int idx = 1; // 트럭들을 순차적으로 넣기 위한 인덱스
        int time = 1; // 결과 값을 담을 목적
        int weightCount = 0; // 전체 트럭이 모두 다리를 빠져 나왔는지 확인하기 위해 사용

        while (!queue.isEmpty()) {
            time++;

            // 다리의 길이만큼 차가 존재하면 pop
            if (queue.size() == bridge_length) {
                if (queue.poll() != 0) { // pop한게 무게가 있는 트럭이라면 증가
                    weightCount++;
                }

                if (weightCount == truckCount) { // 트럭이 모두 다리를 빠져 나왔으면 종료
                    break;
                }
            }

            // 현재 다리 위 트럭들의 무게에 새로운 트럭 무게를 더해도 괜찮으면 queue에 트럭 추가
            if (idx < truckCount && truck_weights[idx] + sumWeight(queue) <= weight) {
                queue.offer(truck_weights[idx]);
                idx++;
                continue;
            }

            // 트럭 무게로 인해 새로운 트럭이 들어갈 수 없다면, 0을 추가해 기존 트럭들이 앞으로 가게 함 ex. 0 0 7 -> 0 7 0
            queue.offer(0);
        }

        return time;
    }

    // 다리 위 트럭들의 무게를 계산하는 메서드
    private static int sumWeight(Queue<Integer> queue) {
        return queue.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
