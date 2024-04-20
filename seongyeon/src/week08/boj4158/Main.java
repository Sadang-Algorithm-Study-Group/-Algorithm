package week08.boj4158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: CD
 */

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력 시작
            String firstLine = reader.readLine();
            while (!firstLine.equals("0 0")) {
                int n = Integer.parseInt(firstLine.split(" ")[0]);
                int m = Integer.parseInt(firstLine.split(" ")[1]);

                long[] cdNumbers1 = new long[n];
                for (int i = 0; i < n; i++) {
                    cdNumbers1[i] = Long.parseLong(reader.readLine());
                }
                long[] cdNumbers2 = new long[m];
                for (int i = 0; i < m; i++) {
                    cdNumbers2[i] = Long.parseLong(reader.readLine());
                }

                System.out.println(solution(cdNumbers1, cdNumbers2));
                firstLine = reader.readLine();
            }
        }
    }

    private static int solution(long[] cdNumbers1, long[] cdNumbers2) {
        int count = 0;

        for (long cdNumber : cdNumbers2) {
            count += binarySearch(cdNumbers1, cdNumber);
        }

        return count;
    }

    private static int binarySearch(long[] cdNumbers, long target) {
        int left = 0;
        int right = cdNumbers.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (cdNumbers[mid] == target) {
                return 1;
            } else if (cdNumbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }
}
