const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [n, ...arr] = input.map((x) => Number(x));

arr.sort((a, b) => b - a);

console.log(arr);
