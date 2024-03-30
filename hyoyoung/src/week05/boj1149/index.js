const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

[N, ...arr] = input.map((x) => x.split(' ').map(Number));

const dp = arr;

for (let i = 1; i < N; i++) {
    dp[i][0] = dp[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
    dp[i][1] = dp[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
    dp[i][2] = dp[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
}

console.log(Math.min(...dp[N - 1]));
// N에서 가져야 하는 색상을 제외한 색상 중 N-1에서 최솟값을 구함
