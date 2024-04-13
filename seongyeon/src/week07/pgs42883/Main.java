package week07.pgs42883;

/**
 * 문제: 큰 수 만들기
 */

public class Main {

    public static void main(String[] args) {
        String number = "1234567890123456789012345678901234567890";
        int k = 1;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        int len = number.length() - k - 1;
        int startIdx = 0;
        StringBuilder result = new StringBuilder();

        while (0 <= len) {
            int idx = findMaxIdx(number, startIdx, number.length() - len);
            result.append(number.charAt(idx));
            startIdx = idx + 1;
            len--;
        }
        return result.toString();
    }

    private static int findMaxIdx(String number, int startIdx, int endIdx) {
        int maxIdx = startIdx;
        int maxValue = '0';

        for (int i = startIdx; i < endIdx; i++) {
            int value = number.charAt(i);

            if (maxValue < value) {
                maxIdx = i;
                maxValue = value;
            }

            if (value == '9') {
                break;
            }
        }

        return maxIdx;
    }
}
