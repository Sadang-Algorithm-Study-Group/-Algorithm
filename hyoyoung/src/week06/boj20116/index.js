//**상자의 균형 */

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [[n, L], arr] = input.map((x) => x.split(' ').map(Number));
let [maxX, maxY] = [arr[0] - L, arr[0] + L];
let psum = Array.from({ length: n + 1 }, () => 0);

for (let i = 1; i <= n; i++) {
    psum[i] = arr[i - 1] + psum[i - 1];
}
let max = psum[n] / (n - 1);

if (max < maxY && max > maxX) {
    console.log('stable');
} else {
    console.log('unstable');
}
