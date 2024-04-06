//**블로그 */

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [n, x] = input[0].split(' ').map(Number);
let arr = input.slice(1, input.length)[0].split(' ').map(Number);

let psum = Array.from({ length: n + 1 }, () => 0);
for (let i = 1; i <= n; i++) {
    psum[i] = arr[i - 1] + psum[i - 1];
}
let max = 0;
let count = 0;
let answer = [];

for (let i = x; i < psum.length; i++) {
    max = Math.max(psum[i] - psum[i - x], max);
    answer.push(psum[i] - psum[i - x]);
}
answer.sort((a, b) => b - a);
for (let x of answer) {
    if (x === max) {
        count++;
    } else break;
}
if (max > 0) {
    console.log(max);
    console.log(count);
} else {
    console.log('SAD');
}
