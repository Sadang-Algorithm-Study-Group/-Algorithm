const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');
let count = parseInt(input.shift());
var array = initArray(count);
var stack = [];
var answer = 0;

function backtracking() {
    for (let i of [1, 2]) {
        if (i === 1 && stack.length && stack[stack.length - 1] === 1) continue;
        stack.push(i);
        if (isSumEqualsCount(stack, count)) {
            let sum = array[0];
            let jSum = 0;

            for (let j of stack) {
                jSum += j;
                sum += array[jSum];
                answer = Math.max(answer, sum);
            }
        }
        if (stack.length < count) {
            backtracking();
        }
        stack.pop();
    }
}

backtracking();
console.log(answer);

function sum(arr) {
    return arr.reduce((acc, curr) => acc + curr, 0);
}

function isSumEqualsCount(arr, count) {
    var s = sum(arr);
    return s === count - 1 || s === count;
}

function initArray(count) {
    var arr = new Array(count + 1);

    for (let i = arr.length - 1; i > 0; i--) {
        arr[i] = parseInt(input.shift());
    }
    return arr;
}