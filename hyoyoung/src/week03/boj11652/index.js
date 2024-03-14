//진짜 왜 틀림....진짜 모르겠어..

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

input.shift();
input = input.map(Number);

let hash = new Map();

for (let x of input) {
    if (hash.has(x)) {
        hash.set(x, hash.get(x) + 1);
    } else hash.set(x, 1);
}
console.log(hash);
let num = 0;
let answer = Number.MAX_SAFE_INTEGER;
for (let [x, y] of hash) {
    if (num < y) {
        //y의 값이 크거나 같으면
        num = Math.max(num, y);
        answer = x;
    } else if (num === y) {
        if (answer > x) {
            answer = Math.min(x, answer);
        }
    }
}

console.log(answer);
