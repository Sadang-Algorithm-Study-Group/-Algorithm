package week08.pgs43238;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return getAnswer(n, times);
    }

    private long getAnswer(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left = 1;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) >> 1;
            long total = Arrays.stream(times).mapToLong(time -> mid / time).sum();

            if (total >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}