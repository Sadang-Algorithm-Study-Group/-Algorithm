package week01.pgs42586;

import java.util.*;

/**
 * 문제: 기능개발
 */

public class Main {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int rest = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.offer(rest);
        }

        int count = 0;
        int maxProgress = queue.peek();
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int currentProgress = queue.poll();
            if (currentProgress <= maxProgress) {
                count++;
                continue;
            }

            result.add(count);
            count = 1;
            maxProgress = currentProgress;
        }

        if (count != 0) {
            result.add(count);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
