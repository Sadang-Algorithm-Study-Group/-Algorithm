package week06.pgs92344;

import java.util.function.Supplier;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] prefixSums = new int[board.length + 1][board[0].length + 1];
        int answer = 0;

        for (int[] array : skill) {
            int type = array[0], r1 = array[1], c1 = array[2], r2 = array[3], c2 = array[4], degree = array[5];
            Supplier<Integer> isDecrease = () -> type == 1 ? -1 : 1;
            prefixSums[r1][c1] += degree * isDecrease.get();
            prefixSums[r2 + 1][c2 + 1] += degree * isDecrease.get();
            prefixSums[r1][c2 + 1] += degree * -isDecrease.get();
            prefixSums[r2 + 1][c1] += degree * -isDecrease.get();
        }
        for (int i = 1; i < prefixSums.length; i++) {
            for (int j = 0; j < prefixSums[i].length; j++) {
                prefixSums[i][j] += prefixSums[i - 1][j];
            }
        }
        for (int i = 1; i < prefixSums[0].length; i++) {
            for (int j = 0; j < prefixSums.length; j++) {
                prefixSums[j][i] += prefixSums[j][i - 1];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + prefixSums[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}