const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [n, ...arr] = input.map((x) => x.split(' ').map(Number));

arr.sort((a, b) => a[0] - b[0]);

let room = 0;

for (let i = 0; i < n; i++) {
    let [a, b] = arr[i];
    if (i + 1 < n && b >= arr[i + 1][0]) room++;
}

console.log(room);
