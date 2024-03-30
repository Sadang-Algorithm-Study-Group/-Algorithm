function solution(triangle) {
    let dp = triangle.slice();
    for (let i = 1; i < dp.length; i++) {
        for (let j = 0; j < dp[i].length; j++) {
            dp[i][j] += Math.max(dp[i - 1][j - 1] ?? 0, dp[i - 1][j] ?? 0);
        }
    }

    // return Math.max(...dp[dp.length-1]);
    return Math.max(...dp.at(-1));
}
