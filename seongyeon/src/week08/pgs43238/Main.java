package week08.pgs43238;

import java.util.Arrays;

/**
 * 문제: 입국 심사
 */

public class Main {

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0;
        long right = (long) times[times.length - 1] * n;
        long minTotalTime = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long countPeople = countPeople(times, mid);

            if (countPeople < n) {
                left = mid + 1;
            } else {
                minTotalTime = Math.min(minTotalTime, mid);
                right = mid - 1;
            }
        }
        return minTotalTime;
    }

    private static long countPeople(int[] times, long totalTime) {
        return Arrays.stream(times)
                .mapToLong(time -> totalTime / time)
                .sum();
    }
}
