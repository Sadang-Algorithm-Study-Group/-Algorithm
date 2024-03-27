package week05.pgs43105;

/**
 * 문제: 정수 삼각형
 */

public class Main {

    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            int[] line = triangle[i];

            for (int j = 0; j < line.length; j++) {
                if (j == 0) {
                    line[j] += triangle[i - 1][j];
                    continue;
                }

                if (j == line.length - 1) {
                    line[j] += triangle[i - 1][j - 1];
                    continue;
                }

                line[j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }

        int result = 0;
        for (int number : triangle[triangle.length - 1]) {
            result = Math.max(result, number);
        }

        return result;
    }
}
