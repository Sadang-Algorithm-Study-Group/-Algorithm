//**가장 긴 증가하는 부분 수열 2 */

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [N, arr] = input.map((x) => x.split(' ').map(Number));

let gap = 0;
let answer = arr.length > 0 ? 1 : 0;
for (let i = 0; i < N; i++) {
    if (arr[i] < arr[i + 1] && arr[i + 1] - arr[i] > gap) {
        gap = arr[i + 1] - arr[i];
        answer++;
    }
}

console.log(answer);
