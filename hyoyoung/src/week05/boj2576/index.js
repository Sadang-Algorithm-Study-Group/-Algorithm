const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

[N, ...arr] = input.map(Number);
let dp = arr;
dp[1] = dp[0] + dp[1];
// dp[2] = Math.max(dp[1]+dp[],dp[0])

console.log(dp);
