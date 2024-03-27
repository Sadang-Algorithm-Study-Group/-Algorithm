const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');
let n = parseInt(input.shift());
var array = input.shift().split(' ').map(Number);
var sum = 0;
var answer = Number.MIN_SAFE_INTEGER;

for (let number of array) {
    sum = Math.max(sum + number, number);
    answer = Math.max(sum, answer);
}
console.log(answer);