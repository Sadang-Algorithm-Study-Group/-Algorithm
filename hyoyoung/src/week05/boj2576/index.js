//**계단 오르기 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [N, ...arr] = input.map(Number);
let dp = arr.slice();
dp[0] = arr[0];
dp[1] = dp[0] + arr[1];
dp[2] = Math.max(dp[0], arr[1]) + arr[2];

for (let i = 3; i < arr.length; i++) {
    dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
}

console.log(dp[arr.length - 1]);
