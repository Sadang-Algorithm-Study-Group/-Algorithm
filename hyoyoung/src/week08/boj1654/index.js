//**랜선자르기 */

//**메모리 17208 시간220 */

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [K, N] = input[0].split(' ').map(Number);

let arr = [];
for (let i = 1; i <= K; i++) {
    arr.push(Number(input[i]));
}
let max = Math.max(...arr);
let min = 1;
while (min <= max) {
    let mid = parseInt((min + max) / 2);
    let sum = 0;
    for (let x of arr) {
        sum += parseInt(x / mid);
    }
    if (sum >= N) min = mid + 1;
    else max = mid - 1;
}

console.log(max);
