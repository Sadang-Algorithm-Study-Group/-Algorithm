// 개똥벌레

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [N, M] = input[0].split(' ').map(Number);

let arr = input.slice(1, input.length).map(Number);

let top = Array.from({ length: M + 1 }).fill(0);
let bottom = Array.from({ length: M + 1 }).fill(0);

arr.forEach((a, i) => {
    i % 2 ? top[M - a + 1]++ : bottom[a]++;
});

for (let i = 1; i <= M; i++) {
    top[i] += top[i - 1];
    bottom[M - i] += bottom[M - i + 1];
}
let min = Infinity;
let count = 0;

for (let i = 1; i <= M; i++) {
    if (top[i] + bottom[i] < min) {
        count = 1;
        min = top[i] + bottom[i];
    } else if (top[i] + bottom[i] === min) {
        count++;
    }
}
console.log(min, count);
