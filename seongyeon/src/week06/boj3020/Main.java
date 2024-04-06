package week06.boj3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 개똥벌레
 * 못 푼 문제! 시간 초과 났다!
 *
 * https://www.acmicpc.net/problem/3020
 */

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int h = Integer.parseInt(firstLine[1]);

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(reader.readLine());
            }

            int lineCount = 0;
            int minCount = n;
            for (int i = 1; i <= h; i++) {
                int currentCount = countBySingleLine(h, n, i, numbers);

                if (currentCount == minCount) {
                    lineCount++;
                    continue;
                }

                if (currentCount < minCount) {
                    minCount = currentCount;
                    lineCount = 1;
                }
            }

            System.out.printf("%d %d", minCount, lineCount);
        }
    }

    private static int countBySingleLine(int h, int n, int lineHeight, int[] numbers) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int length = numbers[i];

            // 석순 (아래)
            if (i % 2 == 0 && lineHeight <= length) {
                count++;
                continue;
            }

            if (i % 2 != 0 && h - length < lineHeight) {
                count++;
            }
        }

        return count;
    }
}
