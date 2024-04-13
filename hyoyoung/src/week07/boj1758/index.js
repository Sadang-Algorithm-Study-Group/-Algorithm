//**알바생 강호 */

// 메모리 25904	시간 252

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [n, ...arr] = input.map((x) => Number(x));

arr.sort((a, b) => b - a);
let money = 0;

for (let i = 0; i < n; i++) {
    let coin = arr[i] - i;
    if (coin <= 0) money += 0;
    else money += coin;
}

console.log(money);
