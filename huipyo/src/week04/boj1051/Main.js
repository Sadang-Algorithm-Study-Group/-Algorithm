const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');
let [n, m] = input.shift().split(' ').map(Number);
var arrays = [];
var size = 1;

for (let i = 0; i < n; i++) {
    arrays.push([...input.shift()]);
}
for (let i = 0; i < Math.min(n, m); i++) {
    size = Math.max(size, linearSearchAndGetSize(arrays, i));
}
console.log(size * size);

function linearSearchAndGetSize(arrays, size) {
    for (let i = 0; i < arrays.length - size; i++) {
        for (let j = 0; j < arrays[i].length - size; j++) {
            if (arrays[i][j] == arrays[i][j + size] && arrays[i][j] == arrays[i + size][j] && arrays[i][j] == arrays[i + size][j + size]) {
                return size + 1;
            }
        }
    }
    return 1;
}