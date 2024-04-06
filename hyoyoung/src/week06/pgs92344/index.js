// 시간초과

function solution(board, skill) {
    var answer = 0;
    for (let [type, r1, c1, r2, c2, degree] of skill) {
        for (let i = r1; i <= r2; i++) {
            for (let j = c1; j <= c2; j++) {
                if (type === 1) {
                    board[i][j] -= degree;
                } else board[i][j] += degree;
            }
        }
    }
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            if (board[i][j] > 0) answer++;
            else continue;
        }
    }
    return answer;
}
