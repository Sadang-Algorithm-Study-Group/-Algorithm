package week09.boj17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 회문
 * 메모리: 29312 KB
 * 시간: 328 ms
 *
 * 문제 링크: https://www.acmicpc.net/problem/17609
 *
 * 못 풀어서 아래 링크 참고했음
 * https://passionfruit200.tistory.com/760
 */

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력
            int n = Integer.parseInt(reader.readLine());
            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = reader.readLine().strip();
            }

            // 출력
            System.out.println(solution(words));
        }
    }

    private static String solution(String[] words) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(checkPalindromeType(0, word.length() - 1, 0, word))
                    .append("\n");
        }
        return result.toString();
    }

    private static int checkPalindromeType(int left, int right, int count, String word) {
        if (2 <= count) {
            return 2;
        }

        while (left < right) {
            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                int changedLeft = checkPalindromeType(left + 1, right, count + 1, word);
                int changedRight = checkPalindromeType(left, right - 1, count + 1, word);
                return Math.min(changedLeft, changedRight);
            }
        }

        return count;
    }
}

//    private static int checkPalindromeType(String word) {
//        int count = 0; // 제거 해야하는 글자 수
//        int left = 0;
//        int right = word.length() - 1;
//
//        while (left < right) {
//            char leftChar = word.charAt(left);
//            char rightChar = word.charAt(right);
//
//            if (leftChar == rightChar) {
//                left++;
//                right--;
//                continue;
//            }
//
//            if (left + 1 == right) {
//                count++;
//                left++;
//                right--;
//                continue;
//            }
//
            // 실패한 코드: 다를 경우 어떤 문자열을 선택하냐에 따라 결과가 다르다 (ex. acbccba)
//            if (left != right - 1 && leftChar == word.charAt(right - 1)) {
//                right--;
//            } else if (right != left + 1 && rightChar == word.charAt(left + 1)) {
//                left++;
//            } else {
//                return 2;
//            }
//
//            count++;
//        }
//
//        if (count == 1) {
//            return 1;
//        } else if (1 < count) {
//            return 2;
//        }
//            return 0;
//        }
//}
