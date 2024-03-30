//**정수삼각형 */
function solution(triangle) {
    let dp = triangle.slice();
    for (let i = 1; i < dp.length; i++) {
        for (let j = 0; j < dp[i].length; j++) {
            dp[i][j] += Math.max(dp[i - 1][j - 1] ?? 0, dp[i - 1][j] ?? 0);
            console.log(dp);
        }
    }

    // return Math.max(...dp[dp.length-1]);
    return Math.max(...dp.at(-1));
}

console.log(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]));
