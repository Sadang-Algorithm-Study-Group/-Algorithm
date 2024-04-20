package week08.pgs43238;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        int left = 1;
        int right = n * times[times.length - 1];

        Arrays.sort(times);
        while (left <= right) {
            int mid = (left + right) / 2;
            int total = Arrays.stream(times).map(time -> mid / time).sum();

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
