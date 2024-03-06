package week02.pgs42587;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new ArrayDeque<>() {
            {
                for (int i = 0; i < priorities.length; i++) offer(new AbstractMap.SimpleEntry<>(i, priorities[i]));
            }
        };
        int answer = 1;

        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> current = queue.poll();

            if (isContainsHigherPriority(new ArrayList<>(queue), current.getValue())) queue.offer(current);
            else if (current.getKey() == location) break;
            else answer++;
        }
        return answer;
    }

    private boolean isContainsHigherPriority(List<AbstractMap.SimpleEntry<Integer, Integer>> queue, int currentPriority) {
        for (AbstractMap.SimpleEntry<Integer, Integer> priority : queue)
            if (priority.getValue() > currentPriority) return true;
        return false;
    }
}
