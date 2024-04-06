//2차원 배열의 합

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [N, M] = input.shift().split(' ').map(Number);
let arr = input.splice(0, N).map((x) => x.split(' ').map(Number));

let [k, ...ijxy] = input.map((x) => x.split(' ').map(Number));

let psum = Array.from({ length: N + 1 }, () => Array(M + 1).fill(0));

for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= M; j++) {
        psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + arr[i - 1][j - 1];
    }
}

for (let [i, j, x, y] of ijxy) {
    let sum = psum[x][y] - psum[x][j - 1] - psum[i - 1][y] + psum[i - 1][j - 1];
    console.log(sum);
}
