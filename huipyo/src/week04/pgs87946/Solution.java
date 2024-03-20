package week04.pgs87946;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

class Solution {
    public int solution(int k, int[][] dungeons) {
        AtomicInteger answer = new AtomicInteger(0);
        LinkedList<Integer> stack = new LinkedList<>();
        Consumer<Integer> backtracking = new Consumer<>() {
            @Override
            public void accept(Integer sum) {
                for (int i = 0; i < dungeons.length; i++) {
                    if (stack.contains(i) || sum < dungeons[i][0]) continue;
                    stack.push(i);
                    answer.set(Math.max(answer.get(), stack.size()));
                    if (stack.size() < dungeons.length) accept(sum - dungeons[i][1]);
                    stack.pop();
                }
            }
        };

        backtracking.accept(k);
        return answer.get();
    }
}