//**연속합 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [N, arr] = input.map((x) => x.split(' ').map(Number));

let dp = [];

for (let i = 0; i < arr.length; i++) {
    dp[i] = arr[i];
    if (dp[i] < dp[i - 1] + arr[i]) {
        dp[i] = dp[i - 1] + arr[i];
    }
}

console.log(Math.max(...dp));
