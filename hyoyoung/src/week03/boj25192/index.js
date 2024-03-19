const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

input.shift();
/**
 * 메모리 : 28780KB
 * 시간 : 248ms
 */
let count = 0;
let set = new Set();

for (let recode of input) {
    if (recode === 'ENTER') {
        set.clear();
    } else if (!set.has(recode)) {
        set.add(recode);
        count++;
    }
}
console.log(count);
