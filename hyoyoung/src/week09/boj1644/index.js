//**소수의 연속합 */

//**메모리 27044 시간 4148 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = Number(fs.readFileSync(filePath).toString().trim().split('\r\n'));

let left = 0;
let right = 0;
let sum = 0;
let count = 0;

function isPrime(num) {
    if (num <= 1) return false;
    if (num % 2 === 0) {
        return num === 2 ? true : false;
    }
    for (let i = 3; i <= parseInt(Math.sqrt(num)); i++) {
        if (num % i === 0) {
            return false;
        }
    }

    return true;
}

let arr = [];
for (let i = 1; i <= input; i++) {
    if (isPrime(i)) arr.push(i);
}
while (right <= arr.length) {
    if (sum === input) {
        count++;
        sum -= arr[left];
        left++;
    } else if (sum < input) {
        sum += arr[right];
        right++;
    } else if (sum > input) {
        sum -= arr[left];
        left++;
    }
}

console.log(count);
