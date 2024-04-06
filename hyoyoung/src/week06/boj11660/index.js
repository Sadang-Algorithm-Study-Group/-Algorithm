//**구간합 구하기 */

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [N, M] = input[0].split(' ').map(Number);

let arr = input.slice(1, N + 1).map((str) => str.split(' ').map(Number));

let psum = Array.from({ length: N + 1 }, () => Array(N + 1).fill(0));
for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
        psum[i][j] = arr[i - 1][j - 1] + psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1];
    }
}

let ans = '';

for (let k = N + 1; k < input.length; k++) {
    let [i, j, x, y] = input[k].split(' ').map(Number);
    let sum = psum[x][y] - psum[x][j - 1] - psum[i - 1][y] + psum[i - 1][j - 1];
    ans += String(sum) + '\n';
}

console.log(ans);
