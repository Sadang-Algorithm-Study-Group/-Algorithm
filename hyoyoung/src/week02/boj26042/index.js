const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let N = input.shift();

input = input.map((x) => x.split(' ').map(Number));

function solution(input) {
    let queue = [];
    let queue2 = [];
    let queue3 = [];
    let count = 0;
    for (let x of input) {
        if (queue2.some((t) => t[0] > queue.length)) {
            console.log(t);
            queue2.push([queue.length, ...queue]);
        } else queue2.push([queue.length, ...queue]);
        if (x[0] === 2) {
            queue.shift();
        } else queue.push(x);
    }
    // console.log(queue2);
    //     let count = 0;
    //     for (let x of queue2) {
    //         count = Math.max(x.length);
    //     }
    // for (let x of queue2) {
    //     if (x.length === count) {
    //         queue3.push(x[x.length - 1][1]);
    //     }
    // }
    // let A = [count, Math.min(...queue3)];
    // console.log(A.join(' '));
}
solution(input);
