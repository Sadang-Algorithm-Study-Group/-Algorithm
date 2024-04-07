//**구간합 구하기 */

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');

let [n, m] = input[0].split(' ').map(Number);

let array = input.slice(1, n + 1).map((str) => str.split(' ').map(Number));

let psum = Array.from({ length: n + 1 }, () => Array(n + 1).fill(0));
for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= n; j++) {
        psum[i][j] = array[i - 1][j - 1] + psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1];
    }
}

let answer = '';

for (let k = n + 1; k < input.length; k++) {
    let [i, j, x, y] = input[k].split(' ').map(Number);
    let sum = psum[x][y] - psum[x][j - 1] - psum[i - 1][y] + psum[i - 1][j - 1];
    answer += String(sum) + '\n';
}

console.log(answer);