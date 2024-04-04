package week06.pgs92344;

import java.util.Arrays;

/**
 * 문제: 파괴되지 않은 건물
 * 효율성 통과를 못함! 시간 초과 !
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 */

public class Main {

    public static final int SAME_TEAM_TYPE = 2;

    public int solution(int[][] board, int[][] skill) {
        for (int[] singleSkill : skill) {
            int type = singleSkill[0];
            int r1 = singleSkill[1];
            int c1 = singleSkill[2];
            int r2 = singleSkill[3];
            int c2 = singleSkill[4];
            int degree = singleSkill[5];

            updateBoard(board, r1, r2, c1, c2, type, degree);
        }

        return countBuilding(board);
    }

    private int countBuilding(int[][] board) {
        return (int) Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .filter(e -> e > 0)
                .count();
    }

    private void updateBoard(int[][] board, int r1, int r2, int c1, int c2, int type, int degree) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (type == SAME_TEAM_TYPE) {
                    board[i][j] += degree;
                } else {
                    board[i][j] -= degree;
                }
            }
        }
    }
}
