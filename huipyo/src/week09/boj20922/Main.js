const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');
let [n, k] = input.shift().split(' ').map(Number);
let array = input.shift().split(' ').map(Number);
var answer = 0;

for (let left = 0; left < array.length - 1; left++) {
    answer = Math.max(answer, getLength(left, k, array));
}
console.log(answer);

function getLength(start, k, array) {
    var map = new Map();
    var count = 0;

    for (let right = start + 1; right < array.length; right++) {
        map.set(array[right], map.get(array[right]) + 1);
        if (map.get(array[right]) > k) break;
        count++;
    }
    return count;
}