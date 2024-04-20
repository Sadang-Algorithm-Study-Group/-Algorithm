package week08.boj11663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제: 선분 위의 점
 */

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = reader.readLine().split(" ");
            int m = Integer.parseInt(firstLine[1]);
            int[] points = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            for (int i = 0; i < m; i++) {
                String[] lineInfo = reader.readLine().split(" ");
                int start = Integer.parseInt(lineInfo[0]);
                int end = Integer.parseInt(lineInfo[1]);

                System.out.println(solution(start, end, points));
            }
        }
    }

    private static int solution(int start, int end, int[] points) {
        int upper = upperBound(end, points);
        int lower = lowerBound(start, points);

        return upper - lower;
    }

    private static int lowerBound(int target, int[] points) {
        int start = 0;
        int end = points.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (points[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    private static int upperBound(int target, int[] points) {
        int start = 0;
        int end = points.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (points[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

//    private static long solution(int start, int end, int[] points) {
//        return Arrays.stream(points)
//                .filter(point -> binarySearch(point, start, end))
//                .count();
//    }
//
//    private static boolean binarySearch(int target, int start, int end) {
//        while (start <= end) {
//            int mid = (start + end) / 2;
//
//            if (mid == target) {
//                return true;
//            }
//            else if (mid < target) {
//                start = mid + 1;
//            }
//            else {
//                end = mid - 1;
//            }
//        }
//        return false;
//    }
}
