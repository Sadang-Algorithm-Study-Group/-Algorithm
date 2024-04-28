package week09.boj15565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제: 귀여운 라이언
 *
 * 못 풀었다!
 * https://www.acmicpc.net/problem/15565
 */

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);
            int[] dolls = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(solution(n, k, dolls));
        }
    }

    private static int solution(int n, int k, int[] dolls) {
        int left = 0;
        int right = 0;
        int ryanCount = 0;
        int minLength = n;

        while (left <= right && right < n) {
            if (dolls[left] != 1) {
                left++;
                continue;
            }

            if (dolls[right] == 1) {
                ryanCount++;
            }

            if (ryanCount == k) {
                minLength = Math.min(minLength, right - left + 1);
                ryanCount--;
                left++;
            }

            right++;
        }

        if (ryanCount == 0 && minLength == n) {
            return -1;
        }
        return minLength;
    }
}
