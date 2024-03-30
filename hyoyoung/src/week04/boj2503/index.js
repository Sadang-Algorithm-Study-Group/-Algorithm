const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let n = input.shift();
let arr = [];

for (let i = 0; i < n; i++) {
    arr.push(input.shift().split(' '));
}
