const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');
let [n, l] = input.shift().split(" ").map(Number);
let array = input.shift().split(" ").map((x) => Number(x)).sort();
var answer = l;

for (e of array) {
    if (answer >= e) answer++;
    else break;
}
console.log(answer);