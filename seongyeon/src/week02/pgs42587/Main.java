package week02.pgs42587;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 문제: 프로세스
 */

public class Main {

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Process> processQueue = IntStream.range(0, priorities.length)
                .mapToObj(i -> new Process(priorities[i], i))
                .collect(Collectors.toCollection(LinkedList::new));

        Arrays.sort(priorities);
        return getOrderByPriorityAndLocation(priorities, location, processQueue);
    }

    private static int getOrderByPriorityAndLocation(int[] priorities, int location, Queue<Process> processQueue) {
        int idx = priorities.length - 1;
        int order = 1;

        while (!processQueue.isEmpty()) {
            int currentPriority = priorities[idx];
            Process process = processQueue.poll();

            if (process.isNotSamePriority(currentPriority)) {
                processQueue.offer(process);
                continue;
            }

            if (process.isSameLocation(location)) {
                return order;
            }

            order++;
            idx--;
        }
        return order;
    }
}

class Process {

    private final int priority;
    private final int location;

    Process(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }

    public boolean isNotSamePriority(int priority) {
        return this.priority != priority;
    }

    public boolean isSameLocation(int location) {
        return this.location == location;
    }
}
