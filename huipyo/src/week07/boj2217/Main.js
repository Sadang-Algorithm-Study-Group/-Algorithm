const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');
let n = Number(input.shift());
var array = Array.from({ length: n }, i => Number(input.shift()));
var answer = 0;

array.sort();
for (var i = 0; i < n; i++) {
    answer = Math.max(array[i] * (n - i), answer);
}
console.log(answer);