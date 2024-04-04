// 개똥벌레 => 시간 초과

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [N, M] = input.shift().split(' ').map(Number);

let arr = input.map((x) => Number(x));

let psum = Array.from({ length: M }, () => 0);

arr.forEach((a, i) => {
    if (i % 2) {
        for (let j = 0; j < a; j++) {
            psum[j]++;
        }
    } else {
        for (let j = M - 1; j > M - 1 - a; j--) {
            psum[j]++;
        }
    }
});

let min = Math.min(...psum);

let count = psum.filter((x) => x === min).length;
console.log(min, count);
