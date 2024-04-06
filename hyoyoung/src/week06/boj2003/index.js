// 수들의 합 2

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [[N, M], arr] = input.map((x) => x.split(' ').map(Number));

let psum = Array.from({ length: N + 1 }, () => 0);

for (let i = 1; i <= N; i++) {
    psum[i] = psum[i - 1] + arr[i - 1];
}
let count = 0;

for (let i = 1; i <= N; i++) {
    for (let j = i - 1; j >= 0; j--) {
        if (psum[i] - psum[j] === M) count++;
    }
}

console.log(count);
