//**겹치는 건 싫어 */

//**메모리 41224	시간 340 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [N, K] = input[0].split(' ').map(Number);

let arr = input[1].split(' ').map(Number);

let left = 0;
let right = 0;
let count = 0;

let map = new Map();

for (let x of arr) {
    map.set(x, 0);
}

while (right < N) {
    if (map.get(arr[right]) !== K) {
        map.set(arr[right], map.get(arr[right]) + 1);
        right++;
    } else {
        map.set(arr[left], map.get(arr[left]) - 1);
        left++;
    }
    count = Math.max(count, right - left);
}

console.log(count ? count : 0);
