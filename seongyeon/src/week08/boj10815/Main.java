package week08.boj10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제: 숫자 카드
 * 메모리: 126928 KB
 * 시간: 1296 ms
 */

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] numberCards = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int m = Integer.parseInt(reader.readLine());
            int[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(solution(numberCards, numbers));
        }
    }

    private static String solution(int[] numberCards, int[] numbers) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(numberCards);

        for (int number : numbers) {
            if (binarySearch(numberCards, number)) {
                result.append("1 ");
                continue;
            }
            result.append("0 ");
        }

        return result.toString();
    }

    private static boolean binarySearch(int[] numberCards, int target) {
        int leftIndex = 0;
        int rightIndex = numberCards.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (rightIndex + leftIndex) / 2;
            if (numberCards[midIndex] == target) {
                return true;
            }

            if (numberCards[midIndex] < target) {
                leftIndex = midIndex + 1;
                continue;
            }

            if (numberCards[midIndex] > target) {
                rightIndex = midIndex - 1;
            }
        }

        return false;
    }
}
